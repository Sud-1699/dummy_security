package com.security.dummy.model;

/*
 *
 *@author Sudhanshu Chaubey on 8/19/2023
 *
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
}
