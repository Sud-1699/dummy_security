package com.security.dummy.controllers;

/*
 *
 *@author Sudhanshu Chaubey on 8/19/2023
 *
 */

import com.security.dummy.config.JwtUtil;
import com.security.dummy.dao.UserDao;
import com.security.dummy.model.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtil jwtUtil;

    @PostMapping("login")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest user) {
        authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        final UserDetails userDetails = userDao.findUserByUserName(user.getUsername());
        if(userDetails != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
        }
        return ResponseEntity.status(400).body("Error occur during authentication");
    }
}
