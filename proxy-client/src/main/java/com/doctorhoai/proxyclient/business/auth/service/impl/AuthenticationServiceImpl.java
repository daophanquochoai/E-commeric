package com.doctorhoai.proxyclient.business.auth.service.impl;

import com.doctorhoai.proxyclient.business.auth.model.request.AuthenticationRequest;
import com.doctorhoai.proxyclient.business.auth.model.response.AuthenticationResponse;
import com.doctorhoai.proxyclient.business.auth.service.AuthenticationService;
import com.doctorhoai.proxyclient.exception.IllegalAuthenticationCredentialsException;
import com.doctorhoai.proxyclient.jwt.security.SecutiryConfig;
import com.doctorhoai.proxyclient.jwt.service.JwtService;
import com.doctorhoai.proxyclient.jwt.util.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        log.info("Authentication create token");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()
            ));
        }
        catch (BadCredentialsException e) {
            log.info("{}", e.getMessage());
            throw new IllegalAuthenticationCredentialsException("#### Bad credentials! ####");
        }
        return new AuthenticationResponse( this.jwtService.generateToken(this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername())));
    }

    @Override
    public Boolean authenticate(String jwt)
    {
        try {
            String username = jwtService.extractUsername(jwt);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            log.info("{}  ** {}", username, userDetails);
            if (username != null && userDetails != null) {
                return true;
            }
        }catch (SignatureException e) {
            // JWT không hợp lệ hoặc bị thay đổi
            System.out.println("Invalid JWT signature");
        } catch (Exception e) {
            // Xử lý các lỗi khác
            System.out.println("JWT authentication failed");
        }
        return false;
    }
}
