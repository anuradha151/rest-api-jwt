package com.example.jwt.demo.model;

import java.io.Serializable;

public class AuthToken implements Serializable {

    private String refresh_token;
    private String access_token;

    public AuthToken() {
    }

    public AuthToken(String refresh_token, String access_token) {
        this.setRefresh_token(refresh_token);
        this.setAccess_token(access_token);
    }

    @Override
    public String toString() {
        return "AuthToken{" +
                "refresh_token='" + getRefresh_token() + '\'' +
                ", access_token='" + getAccess_token() + '\'' +
                '}';
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
