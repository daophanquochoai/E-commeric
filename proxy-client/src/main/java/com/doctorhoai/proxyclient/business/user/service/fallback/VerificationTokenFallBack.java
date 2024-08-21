package com.doctorhoai.proxyclient.business.user.service.fallback;

import com.doctorhoai.proxyclient.business.user.model.VerificatationTokenDto;
import com.doctorhoai.proxyclient.business.user.service.VerificationTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VerificationTokenFallBack implements VerificationTokenService {
    @Override
    public ResponseEntity<List<VerificatationTokenDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<VerificatationTokenDto> findById(Long verificationTokenId) {
        return null;
    }

    @Override
    public ResponseEntity<VerificatationTokenDto> save(VerificatationTokenDto verificationTokenDto) {
        return null;
    }

    @Override
    public ResponseEntity<VerificatationTokenDto> update(VerificatationTokenDto verificationTokenDto) {
        return null;
    }

    @Override
    public ResponseEntity<VerificatationTokenDto> update(Long verificationTokenId, VerificatationTokenDto verificationTokenDto) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long verificationTokenId) {
        return null;
    }
}
