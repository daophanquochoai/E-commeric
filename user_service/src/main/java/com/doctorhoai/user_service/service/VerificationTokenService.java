package com.doctorhoai.user_service.service;

import com.doctorhoai.user_service.dto.VerificatationTokenDto;

import java.util.List;

public interface VerificationTokenService {
    List<VerificatationTokenDto> findAll();
    VerificatationTokenDto findById(final Long verificationTokenId);
    VerificatationTokenDto save(final VerificatationTokenDto verificationTokenDto);
    VerificatationTokenDto update(final VerificatationTokenDto verificationTokenDto);
    VerificatationTokenDto update(final Long verificationTokenId, final VerificatationTokenDto verificationTokenDto);
    void deleteById(final Long verificationTokenId);
}
