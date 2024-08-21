package com.doctorhoai.user_service.controller;

import com.doctorhoai.user_service.dto.VerificatationTokenDto;
import com.doctorhoai.user_service.service.VerificationTokenService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/verificationTokens"})
@Slf4j
@RequiredArgsConstructor
public class VerificationTokenController {
    private final VerificationTokenService verificationTokenService;

    @GetMapping
    public ResponseEntity<List<VerificatationTokenDto>> findAll() {
        log.info("*** VerificationTokenDto List, controller; fetch all verificationTokens *");
        return ResponseEntity.ok(this.verificationTokenService.findAll());
    }

    @GetMapping("/{verificationTokenId}")
    public ResponseEntity<VerificatationTokenDto> findById(
            @PathVariable("verificationTokenId")
            @NotBlank(message = "Input must not blank")
            @Valid final Long verificationTokenId) {
        return ResponseEntity.ok(this.verificationTokenService.findById(verificationTokenId));
    }

    @PostMapping
    public ResponseEntity<VerificatationTokenDto> save(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final VerificatationTokenDto verificationTokenDto) {
        log.info("*** VerificationTokenDto, resource; save verificationToken *");
        return ResponseEntity.ok(this.verificationTokenService.save(verificationTokenDto));
    }

    @PutMapping
    public ResponseEntity<VerificatationTokenDto> update(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final VerificatationTokenDto verificationTokenDto) {
        log.info("*** VerificationTokenDto, resource; update verificationToken *");
        return ResponseEntity.ok(this.verificationTokenService.update(verificationTokenDto));
    }

    @PutMapping("/{verificationTokenId}")
    public ResponseEntity<VerificatationTokenDto> update(
            @PathVariable("verificationTokenId")
            @NotBlank(message = "Input must not blank") final Long verificationTokenId,
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final VerificatationTokenDto verificationTokenDto) {
        log.info("*** VerificationTokenDto, resource; update verificationToken with verificationTokenId *");
        return ResponseEntity.ok(this.verificationTokenService.update(verificationTokenId, verificationTokenDto));
    }

    @DeleteMapping("/{verificationTokenId}")
    public ResponseEntity<Boolean> deleteById(
            @PathVariable("verificationTokenId")
            @NotBlank(message = "Input must not blank") final Long verificationTokenId) {
        log.info("*** Boolean, resource; delete verificationToken by id *");
        this.verificationTokenService.deleteById(verificationTokenId);
        return ResponseEntity.ok(true);
    }
}
