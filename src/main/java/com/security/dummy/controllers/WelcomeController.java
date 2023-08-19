package com.security.dummy.controllers;

/*
 *
 *@author Sudhanshu Chaubey on 8/15/2023
 *
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class WelcomeController {

    @GetMapping("greeting")
    public ResponseEntity<String> greetHello() {
        return ResponseEntity.ok("Hello From Spring Security");
    }

    @GetMapping("sayGoodBye")
    public ResponseEntity<String> sayGoodBye() {
        return ResponseEntity.ok("Good Bye From Spring Security");
    }
}
