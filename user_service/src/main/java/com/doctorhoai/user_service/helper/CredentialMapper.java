package com.doctorhoai.user_service.helper;

import com.doctorhoai.user_service.dto.CredentialDto;
import com.doctorhoai.user_service.dto.UserDto;
import com.doctorhoai.user_service.entity.Credential;
import com.doctorhoai.user_service.entity.Users;

public class CredentialMapper {
    public static CredentialDto mapToCredentialDto(final Credential credential){
        CredentialDto credentialDto = CredentialDto.builder()
                .credentialId(credential.getCredentialId())
                .username(credential.getUsername())
                .password(credential.getPassword())
                .roleBasedAuthority(credential.getRoleBasedAuthority())
                .isEnabled(credential.getIsEnabled())
                .isAccountNoExpired(credential.getIsAccountNoExpired())
                .isAccountNoLocked(credential.getIsAccountNoLocked())
                .isCredentialsNonExpired(credential.getIsCredentialsNonExpired())
                .build();
        if( credential.getUser() != null ){
            credentialDto.setUserDto(
                    UserDto.builder()
                            .userId(credential.getUser().getUserId())
                            .firstName(credential.getUser().getFirstName())
                            .lastName(credential.getUser().getLastName())
                            .imageUrl(credential.getUser().getImageUrl())
                            .email(credential.getUser().getEmail())
                            .phone(credential.getUser().getPhone())
                            .build()
            );
        }
        return credentialDto;
    }
    public static Credential mapToCredential(final CredentialDto credentialDto){
        Credential credential = Credential.builder()
                .credentialId(credentialDto.getCredentialId())
                .username(credentialDto.getUsername())
                .password(credentialDto.getPassword())
                .roleBasedAuthority(credentialDto.getRoleBasedAuthority())
                .isEnabled(credentialDto.getIsEnabled())
                .isAccountNoExpired(credentialDto.getIsAccountNoExpired())
                .isAccountNoLocked(credentialDto.getIsAccountNoLocked())
                .isCredentialsNonExpired(credentialDto.getIsCredentialsNonExpired())
                .build();
        if( credentialDto.getUserDto() != null ){
            credential.setUser(
                    Users.builder()
                            .userId(credentialDto.getUserDto().getUserId())
                            .firstName(credentialDto.getUserDto().getFirstName())
                            .lastName(credentialDto.getUserDto().getLastName())
                            .imageUrl(credentialDto.getUserDto().getImageUrl())
                            .email(credentialDto.getUserDto().getEmail())
                            .phone(credentialDto.getUserDto().getPhone())
                            .build()
            );
        }
        return credential;
    }
}
