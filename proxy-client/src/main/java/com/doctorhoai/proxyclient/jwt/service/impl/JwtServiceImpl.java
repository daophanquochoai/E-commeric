package com.doctorhoai.proxyclient.jwt.service.impl;

import com.doctorhoai.proxyclient.jwt.service.JwtService;
import com.doctorhoai.proxyclient.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    private final JwtUtil jwtUtil;
    @Override
    public String extractUsername(String token) {
        return jwtUtil.extractUsername(token);
    }

    @Override
    public Date extractExpiration(String token) {
        return jwtUtil.extractExpiration(token);
    }

    @Override
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        return jwtUtil.extractClaims(token, claimsResolver);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return jwtUtil.generateToken(userDetails);
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        return jwtUtil.validateToken(token, userDetails);
    }
}
