package com.doctorhoai.proxyclient.jwt.util.impl;

import com.doctorhoai.proxyclient.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtilImpl implements JwtUtil {

    private static final String SECRET_KEY = "secret";
    private static final Integer expiration = 1000*60*60*10;
    @Override
    public String extractUsername(String token) {
        return this.extractClaims(token, Claims::getSubject);
    }

    @Override
    public Date extractExpiration(String token) {
        return this.extractClaims(token, Claims::getExpiration);
    }

    @Override
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        final Map<String, Object> claims = new HashMap<>();

        return this.createToken(claims, userDetails.getUsername());
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = this.extractUsername(token);
        return (
                username.equals(userDetails.getUsername()) && !isTokenExpired(token)
                );
    }

    private Boolean isTokenExpired( final String token ){
        return this.extractExpiration(token).before(new Date());
    }
    private Claims extractAllClaims( final String token ){
        return Jwts.parser().setSigningKey("secret")
                .parseClaimsJws(token).getBody();
    }
    private String createToken( final Map<String, Object> claims, final String subject ){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith( SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
