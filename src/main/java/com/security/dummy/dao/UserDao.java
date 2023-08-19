package com.security.dummy.dao;

/*
 *
 *@author Sudhanshu Chaubey on 8/19/2023
 *
 */

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {

    //Can Be Implement below data using DB
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User("abc1699",
                    "password1",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
                new User("xyz1234",
                    "password1",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    public UserDetails findUserByUserName(String username) {
        return APPLICATION_USERS.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No username are found"));
    }
}
