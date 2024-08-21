package com.doctorhoai.proxyclient.business.user.service.fallback;

import com.doctorhoai.proxyclient.business.user.model.CredentialDto;
import com.doctorhoai.proxyclient.business.user.service.CredentialClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CredentialClientFallBack implements CredentialClientService {
    @Override
    public ResponseEntity<List<CredentialDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<CredentialDto> findById(Long credentialId) {
        return null;
    }

    @Override
    public ResponseEntity<CredentialDto> save(CredentialDto credentialDto) {
        return null;
    }

    @Override
    public ResponseEntity<CredentialDto> update(CredentialDto credentialDto) {
        return null;
    }

    @Override
    public ResponseEntity<CredentialDto> update(Long credentialId, CredentialDto credentialDto) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long credentialId) {
        return null;
    }

    @Override
    public ResponseEntity<CredentialDto> findByUsername(String username) {
        return null;
    }
}
