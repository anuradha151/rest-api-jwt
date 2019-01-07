package com.example.jwt.demo.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtGenerator {

    public static String generateAccessJWT(String subject, String uuid, Collection<? extends GrantedAuthority> authorities, int expiration, String secret) {
        Instant now = Instant.now();
        return Jwts.builder().setSubject(subject)
                .claim("authorities", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(expiration)))
                .signWith(SignatureAlgorithm.HS256, secret.getBytes()).claim("ud", uuid)
                .claim("type", "ACCESS").compact();
    }


    public static String generateRefreshToken(String subject, String uuid, Collection<? extends GrantedAuthority> authorities, int expiration, String secret) {
        Instant now = Instant.now();
        return Jwts.builder().setSubject(subject).claim("authorities", authorities.stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(Date.from(now)).setExpiration(Date.from(now.plusSeconds(expiration)))
                .signWith(SignatureAlgorithm.HS256, secret.getBytes()).claim("ud", uuid)
                .claim("type", "REFRESH").compact();
    }

}
