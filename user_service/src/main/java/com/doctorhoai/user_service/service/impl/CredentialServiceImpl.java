package com.doctorhoai.user_service.service.impl;

import com.doctorhoai.user_service.dto.CredentialDto;
import com.doctorhoai.user_service.entity.Credential;
import com.doctorhoai.user_service.entity.Users;
import com.doctorhoai.user_service.exception.ObjectNotFound;
import com.doctorhoai.user_service.helper.CredentialMapper;
import com.doctorhoai.user_service.repository.CredentialRepository;
import com.doctorhoai.user_service.repository.UserRepository;
import com.doctorhoai.user_service.service.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements CredentialService {

    private final CredentialRepository repository;
    private final UserRepository userRepository;
    @Override
    public List<CredentialDto> findAll() {
        return repository.findAll().stream().map(CredentialMapper::mapToCredentialDto).distinct().collect(Collectors.toList());
    }

    @Override
    public CredentialDto findById(Long credentialId) {
        return CredentialMapper.mapToCredentialDto(
                repository.findById(credentialId).orElseThrow(
                        () -> new ObjectNotFound("Credential not found with Id : " + credentialId )
                )
        );
    }

    @Override
    public CredentialDto save(CredentialDto credentialDto) {
        Credential credential = CredentialMapper.mapToCredential(credentialDto);
        credential.setPassword( passwordEncoder().encode(credential.getPassword()));
        Users users = userRepository.findById(credentialDto.getUserDto().getUserId()).orElseThrow(
                () -> new ObjectNotFound("User not found with Id : " + credentialDto.getUserDto().getUserId())
        );
        credential.setUser(users);
        return CredentialMapper.mapToCredentialDto(
                repository.save(credential)
        );
    }

    @Override
    public CredentialDto update(CredentialDto credentialDto) {
        return CredentialMapper.mapToCredentialDto(
                repository.save(CredentialMapper.mapToCredential(credentialDto))
        );
    }

    @Override
    public CredentialDto update(Long credentialId, CredentialDto credentialDto) {
        Credential credential = repository.findById(
            credentialId
        ).orElseThrow(
                () -> new ObjectNotFound("Credential not found with Id : " + credentialId )
        );
        if( credentialDto.getUsername() != null ){
            credential.setUsername(credentialDto.getUsername());
        }
        if( credentialDto.getPassword() != null ){
            credential.setPassword(credentialDto.getPassword());
        }
        if( credentialDto.getRoleBasedAuthority() != null ){
            credential.setRoleBasedAuthority( credentialDto.getRoleBasedAuthority());
        }
        if( credentialDto.getIsEnabled() != null ){
            credential.setIsEnabled(credentialDto.getIsEnabled());
        }
        if( credentialDto.getIsCredentialsNonExpired() != null ){
            credential.setIsCredentialsNonExpired(credentialDto.getIsCredentialsNonExpired());
        }
        if( credentialDto.getIsAccountNoLocked() != null ){
            credential.setIsAccountNoLocked( credentialDto.getIsAccountNoLocked());
        }
        if( credentialDto.getIsAccountNoExpired() != null ){
            credential.setIsAccountNoExpired( credentialDto.getIsAccountNoExpired());
        }
        return CredentialMapper.mapToCredentialDto(repository.save(credential));
    }

    @Override
    public void deleteById(Long credentialId) {
        repository.findById(credentialId).orElseThrow(
                () -> new ObjectNotFound("Credential not found with Id : " + credentialId )
        );
        repository.deleteById(credentialId);
    }

    @Override
    public CredentialDto findByUsername(String username) {
        return CredentialMapper.mapToCredentialDto( repository.findByUsername(username).orElseThrow(
                () -> new ObjectNotFound("Credential not found with username : " + username )
        ));
    }

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
