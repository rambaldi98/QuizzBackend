package com.example.server.model;

import lombok.Data;

@Data
public class JwtRequest {
    String username;
    String password;

    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
