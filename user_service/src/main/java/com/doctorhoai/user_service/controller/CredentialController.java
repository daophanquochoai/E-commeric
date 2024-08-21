package com.doctorhoai.user_service.controller;

import com.doctorhoai.user_service.dto.CredentialDto;
import com.doctorhoai.user_service.service.CredentialService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/credentials"})
@Slf4j
@RequiredArgsConstructor
public class CredentialController {
    private final CredentialService credentialService;

    @GetMapping
    public ResponseEntity<List<CredentialDto>> findAll() {
        log.info("*** CredentialDto List, controller; fetch all credentials *");
        return ResponseEntity.ok(credentialService.findAll());
    }

    @GetMapping("/{credentialId}")
    public ResponseEntity<CredentialDto> findById(
            @PathVariable("credentialId")
            @NotBlank(message = "Input must not blank")
            @Valid final Long credentialId) {
        return ResponseEntity.ok(this.credentialService.findById(credentialId));
    }

    @PostMapping
    public ResponseEntity<CredentialDto> save(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final CredentialDto credentialDto) {
        return ResponseEntity.ok(this.credentialService.save(credentialDto));
    }

    @PutMapping
    public ResponseEntity<CredentialDto> update(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final CredentialDto credentialDto) {
        return ResponseEntity.ok(this.credentialService.update(credentialDto));
    }

    @PutMapping("/{credentialId}")
    public ResponseEntity<CredentialDto> update(
            @PathVariable("credentialId")
            @NotBlank(message = "Input must not blank") final Long credentialId,
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final CredentialDto credentialDto) {
        return ResponseEntity.ok(this.credentialService.update(credentialId, credentialDto));
    }

    @DeleteMapping("/{credentialId}")
    public ResponseEntity<Boolean> deleteById(
            @PathVariable("credentialId")
            @NotBlank(message = "Input must not blank")
            @Valid final Long credentialId) {
        this.credentialService.deleteById(credentialId);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<CredentialDto> findByUsername(
            @PathVariable("username")
            @NotBlank(message = "Input must not blank")
            @Valid final String username) {
        return ResponseEntity.ok(this.credentialService.findByUsername(username));
    }
}
