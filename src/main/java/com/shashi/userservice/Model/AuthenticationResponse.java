package com.shashi.userservice.Model;

import java.io.Serializable;

/**
 * @author akshaygupta01
 */
public class AuthenticationResponse implements Serializable {
    private final String jwt;
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
