package com.doctorhoai.proxyclient.business.user.service;


import com.doctorhoai.proxyclient.business.user.model.VerificatationTokenDto;
import com.doctorhoai.proxyclient.business.user.service.fallback.VerificationTokenFallBack;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient( name = "apigateway", contextId = "gatewayVerification" , fallback = VerificationTokenFallBack.class, path = "doctorhoai/user/api/verificationTokens")
public interface VerificationTokenService {
    @GetMapping
    public ResponseEntity<List<VerificatationTokenDto>> findAll();

    @GetMapping("/{verificationTokenId}")
    public ResponseEntity<VerificatationTokenDto> findById(
            @PathVariable("verificationTokenId")
            @NotBlank(message = "Input must not blank")
            @Valid final Long verificationTokenId);
    @PostMapping
    public ResponseEntity<VerificatationTokenDto> save(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final VerificatationTokenDto verificationTokenDto);

    @PutMapping
    public ResponseEntity<VerificatationTokenDto> update(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final VerificatationTokenDto verificationTokenDto);

    @PutMapping("/{verificationTokenId}")
    public ResponseEntity<VerificatationTokenDto> update(
            @PathVariable("verificationTokenId")
            @NotBlank(message = "Input must not blank") final Long verificationTokenId,
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final VerificatationTokenDto verificationTokenDto);

    @DeleteMapping("/{verificationTokenId}")
    public ResponseEntity<Boolean> deleteById(
            @PathVariable("verificationTokenId")
            @NotBlank(message = "Input must not blank") final Long verificationTokenId);
}

