package com.doctorhoai.proxyclient.business.user.service;

import com.doctorhoai.proxyclient.business.user.model.CredentialDto;
import com.doctorhoai.proxyclient.business.user.service.fallback.CredentialClientFallBack;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient( name = "apigateway", contextId = "gatewayCredential" ,fallback = CredentialClientFallBack.class, path = "doctorhoai/user/api/credentials")
public interface CredentialClientService {
    @GetMapping
    public ResponseEntity<List<CredentialDto>> findAll();

    @GetMapping("/{credentialId}")
    public ResponseEntity<CredentialDto> findById(
            @PathVariable("credentialId")
            @NotBlank(message = "Input must not blank")
            @Valid final Long credentialId);

    @PostMapping
    public ResponseEntity<CredentialDto> save(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final CredentialDto credentialDto);

    @PutMapping
    public ResponseEntity<CredentialDto> update(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final CredentialDto credentialDto);

    @PutMapping("/{credentialId}")
    public ResponseEntity<CredentialDto> update(
            @PathVariable("credentialId")
            @NotBlank(message = "Input must not blank") final Long credentialId,
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final CredentialDto credentialDto);

    @DeleteMapping("/{credentialId}")
    public ResponseEntity<Boolean> deleteById(
            @PathVariable("credentialId")
            @NotBlank(message = "Input must not blank")
            @Valid final Long credentialId);

    @GetMapping("/username/{username}")
    public ResponseEntity<CredentialDto> findByUsername(
            @PathVariable("username")
            @NotBlank(message = "Input must not blank")
            @Valid final String username);
}
