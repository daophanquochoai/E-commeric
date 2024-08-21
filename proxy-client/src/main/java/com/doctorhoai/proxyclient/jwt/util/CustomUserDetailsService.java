package com.doctorhoai.proxyclient.jwt.util;

import com.doctorhoai.proxyclient.entity.Credential;
import com.doctorhoai.proxyclient.repository.CredentialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final CredentialRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential credential = repository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("credential not found")
        );
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.singleton(new SimpleGrantedAuthority(credential.getRoleBasedAuthority().getRole()));
            }

            @Override
            public String getPassword() {
                return credential.getPassword();
            }

            @Override
            public String getUsername() {
                return credential.getUsername();
            }
        };
        log.info("{}", userDetails);
        return userDetails;
    }
}
