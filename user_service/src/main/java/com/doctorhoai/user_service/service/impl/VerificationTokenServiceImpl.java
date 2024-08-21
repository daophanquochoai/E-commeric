package com.doctorhoai.user_service.service.impl;

import com.doctorhoai.user_service.dto.VerificatationTokenDto;
import com.doctorhoai.user_service.entity.VerificationToken;
import com.doctorhoai.user_service.exception.ObjectNotFound;
import com.doctorhoai.user_service.helper.VerificationTokenMapper;
import com.doctorhoai.user_service.repository.VerificationTokenRepository;
import com.doctorhoai.user_service.service.VerificationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService {
    private final VerificationTokenRepository repository;
    @Override
    public List<VerificatationTokenDto> findAll() {
        return repository.findAll().stream().map(VerificationTokenMapper::mapToVerificationTokenDto).distinct().collect(Collectors.toList());
    }

    @Override
    public VerificatationTokenDto findById(Long verificationTokenId) {
        return VerificationTokenMapper.mapToVerificationTokenDto(repository.findById(verificationTokenId).orElseThrow(
                () -> new ObjectNotFound("Verification not found with Id : "+ verificationTokenId)
        ));
    }

    @Override
    public VerificatationTokenDto save(VerificatationTokenDto verificationTokenDto) {
        return VerificationTokenMapper.mapToVerificationTokenDto(repository.save(VerificationTokenMapper.mapToVerificationToken(verificationTokenDto)));
    }

    @Override
    public VerificatationTokenDto update(VerificatationTokenDto verificationTokenDto) {
        return VerificationTokenMapper.mapToVerificationTokenDto(repository.save(VerificationTokenMapper.mapToVerificationToken(verificationTokenDto)));
    }

    @Override
    public VerificatationTokenDto update(Long verificationTokenId, VerificatationTokenDto verificationTokenDto) {
        VerificationToken verificationToken = repository.findById(verificationTokenId).orElseThrow(
                () -> new ObjectNotFound("Verification not found with Id : "+ verificationTokenId)
        );
        if( verificationTokenDto.getToken() != null ){
            verificationToken.setToken(verificationTokenDto.getToken());
        }
        if( verificationTokenDto.getExpireDate() != null ){
            verificationToken.setExpireDate(verificationTokenDto.getExpireDate());
        }
        return VerificationTokenMapper.mapToVerificationTokenDto(repository.save(verificationToken));

    }

    @Override
    public void deleteById(Long verificationTokenId) {
        repository.findById(verificationTokenId).orElseThrow(
                () -> new ObjectNotFound("Verification not found with Id : "+ verificationTokenId)
        );
        repository.deleteById(verificationTokenId);
    }
}
