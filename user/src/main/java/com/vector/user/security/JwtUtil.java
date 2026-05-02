package com.vector.user.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "bXktc3VwZXItc2VjcmV0LWtleS10aGF0LWlzLTMyLWJ5dGVzIQ==";

    public String generateToken(String userId) {
        return Jwts.builder()
                .setSubject(userId) // store userId here
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String extractUserId(String token) {
        return extractAllClaims(token).getSubject(); // store userId as subject
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
