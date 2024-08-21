package com.doctorhoai.user_service.service;

import com.doctorhoai.user_service.dto.CredentialDto;

import java.util.List;

public interface CredentialService {
    List<CredentialDto> findAll();
    CredentialDto findById(final Long credentialId);
    CredentialDto save(final CredentialDto credentialDto);
    CredentialDto update(final CredentialDto credentialDto);
    CredentialDto update(final Long credentialId, final CredentialDto credentialDto);
    void deleteById(final Long credentialId);
    CredentialDto findByUsername(final String username);
}
