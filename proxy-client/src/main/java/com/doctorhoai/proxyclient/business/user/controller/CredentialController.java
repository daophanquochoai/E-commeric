package com.doctorhoai.proxyclient.business.user.controller;

import com.doctorhoai.proxyclient.business.user.model.CredentialDto;
import com.doctorhoai.proxyclient.business.user.service.CredentialClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credential")
@RequiredArgsConstructor
public class CredentialController {

    private final CredentialClientService credentialClientService;
    @GetMapping
    public ResponseEntity<List<CredentialDto>> findAll() {
        return ResponseEntity.ok(
                this.credentialClientService.findAll() != null ?
                        this.credentialClientService.findAll().getBody() : null
        );
    }

    @GetMapping("/{credentialId}")
    public ResponseEntity<CredentialDto> findById(@PathVariable("credentialId") final Long credentialId) {
        return ResponseEntity.ok(
                this.credentialClientService.findById(credentialId) != null ?
                        this.credentialClientService.findById(credentialId).getBody() : null
        );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<CredentialDto> findByCredentialname(@PathVariable("username") final String username) {
        return ResponseEntity.ok(
                this.credentialClientService.findByUsername(username) != null ?
                        this.credentialClientService.findByUsername(username).getBody() : null
        );
    }

    @PostMapping
    public ResponseEntity<CredentialDto> save(@RequestBody final CredentialDto credentialDto) {
        return ResponseEntity.ok(
                this.credentialClientService.save(credentialDto) != null ?
                        this.credentialClientService.save(credentialDto).getBody() : null
        );
    }

    @PutMapping
    public ResponseEntity<CredentialDto> update(@RequestBody final CredentialDto credentialDto) {
        return ResponseEntity.ok(
                this.credentialClientService.update(credentialDto) != null ?
                        this.credentialClientService.update(credentialDto).getBody() : null
        );
    }

    @PutMapping("/{credentialId}")
    public ResponseEntity<CredentialDto> update(@PathVariable("credentialId") final String credentialId, @RequestBody final CredentialDto credentialDto) {
        return ResponseEntity.ok(
                this.credentialClientService.update(credentialDto) != null ?
                        this.credentialClientService.update(credentialDto).getBody() : null
        );
    }

    @DeleteMapping("/{credentialId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("credentialId") final Long credentialId) {
        return ResponseEntity.ok(
                this.credentialClientService.deleteById(credentialId) != null ?
                        this.credentialClientService.deleteById(credentialId).getBody() : null
        );
    }
}
