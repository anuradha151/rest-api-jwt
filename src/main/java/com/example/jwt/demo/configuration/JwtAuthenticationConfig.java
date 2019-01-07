package com.example.jwt.demo.configuration;

import org.springframework.beans.factory.annotation.Value;

public class JwtAuthenticationConfig {

    @Value("${jwt.url:/login}")
    private String url;

    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.prefix}")
    private String prefix;

    @Value("${jwt.expiration}")
    private int expiration; // default 8 hours

    @Value(ApiParameters.JWT_SECRET)
    private String secret;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

/*    public static void main(String[] args) {
        JwtAuthenticationConfig cnf=new JwtAuthenticationConfig();
        System.out.println(cnf.getUrl());
    }*/

}
