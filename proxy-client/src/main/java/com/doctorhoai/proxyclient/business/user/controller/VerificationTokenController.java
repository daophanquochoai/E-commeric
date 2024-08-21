package com.doctorhoai.proxyclient.business.user.controller;


import com.doctorhoai.proxyclient.business.user.model.VerificatationTokenDto;
import com.doctorhoai.proxyclient.business.user.service.VerificationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verificationTokens")
@RequiredArgsConstructor
public class VerificationTokenController {

    private final VerificationTokenService verificationTokenClientService;

    @GetMapping
    public ResponseEntity<List<VerificatationTokenDto>> findAll() {
        return ResponseEntity.ok(
                this.verificationTokenClientService.findAll() != null ?
                        this.verificationTokenClientService.findAll().getBody() : null
        );
    }

    @GetMapping("/{verificationTokenId}")
    public ResponseEntity<VerificatationTokenDto> findById(@PathVariable("verificationTokenId") final Long verificationTokenId) {
        return ResponseEntity.ok(
                this.verificationTokenClientService.findById(verificationTokenId) != null ?
                        this.verificationTokenClientService.findById(verificationTokenId).getBody() : null
        );
    }

    @PostMapping
    public ResponseEntity<VerificatationTokenDto> save(@RequestBody final VerificatationTokenDto verificationTokenDto) {
        return ResponseEntity.ok(
                this.verificationTokenClientService.save(verificationTokenDto) != null ?
                        this.verificationTokenClientService.save(verificationTokenDto).getBody() : null
        );
    }

    @PutMapping
    public ResponseEntity<VerificatationTokenDto> update(@RequestBody final VerificatationTokenDto verificationTokenDto) {
        return ResponseEntity.ok(
                this.verificationTokenClientService.update(verificationTokenDto) != null ?
                        this.verificationTokenClientService.update(verificationTokenDto).getBody() : null
        );
    }

    @PutMapping("/{verificationTokenId}")
    public ResponseEntity<VerificatationTokenDto> update(@PathVariable("verificationTokenId") final Long verificationTokenId, @RequestBody final VerificatationTokenDto verificationTokenDto) {
        return ResponseEntity.ok(
                this.verificationTokenClientService.update(verificationTokenDto) != null ?
                        this.verificationTokenClientService.update(verificationTokenDto).getBody() : null
        );
    }

    @DeleteMapping("/{verificationTokenId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("verificationTokenId") final Long verificationTokenId) {
        return ResponseEntity.ok(
                this.verificationTokenClientService.deleteById(verificationTokenId) != null ?
                        this.verificationTokenClientService.deleteById(verificationTokenId).getBody() : null
        );
    }



}