package com.doctorhoai.user_service.helper;

import com.doctorhoai.user_service.dto.CredentialDto;
import com.doctorhoai.user_service.dto.VerificatationTokenDto;
import com.doctorhoai.user_service.entity.Credential;
import com.doctorhoai.user_service.entity.VerificationToken;

public class VerificationTokenMapper {
    public static VerificationToken mapToVerificationToken(final VerificatationTokenDto verificatationTokenDto){
        VerificationToken verificationToken = VerificationToken.builder()
                .verificationTokenId(verificatationTokenDto.getVerificationTokenId())
                .token(verificatationTokenDto.getToken())
                .expireDate(verificatationTokenDto.getExpireDate())
                .build();
        if( verificatationTokenDto.getCredentialDto() != null ){
            verificationToken.setCredential(
                    Credential.builder()
                            .credentialId(verificatationTokenDto.getCredentialDto().getCredentialId())
                            .username(verificatationTokenDto.getCredentialDto().getUsername())
                            .password(verificatationTokenDto.getCredentialDto().getPassword())
                            .roleBasedAuthority(verificatationTokenDto.getCredentialDto().getRoleBasedAuthority())
                            .isEnabled(verificatationTokenDto.getCredentialDto().getIsEnabled())
                            .isAccountNoExpired(verificatationTokenDto.getCredentialDto().getIsAccountNoExpired())
                            .isAccountNoLocked(verificatationTokenDto.getCredentialDto().getIsAccountNoLocked())
                            .isCredentialsNonExpired(verificatationTokenDto.getCredentialDto().getIsCredentialsNonExpired())
                            .build()
            );
        }
        return verificationToken;
    }
    public static VerificatationTokenDto mapToVerificationTokenDto( final VerificationToken verificationToken){
        VerificatationTokenDto verificatationTokenDto =
                VerificatationTokenDto.builder()
                        .verificationTokenId(verificationToken.getVerificationTokenId())
                        .token(verificationToken.getToken())
                        .expireDate(verificationToken.getExpireDate())
                        .build();
        if( verificationToken.getCredential() != null ){
            verificatationTokenDto.setCredentialDto(
                    CredentialDto.builder()
                            .credentialId(verificationToken.getCredential().getCredentialId())
                            .username(verificationToken.getCredential().getUsername())
                            .password(verificationToken.getCredential().getPassword())
                            .roleBasedAuthority(verificationToken.getCredential().getRoleBasedAuthority())
                            .isEnabled(verificationToken.getCredential().getIsEnabled())
                            .isAccountNoExpired(verificationToken.getCredential().getIsAccountNoExpired())
                            .isAccountNoLocked(verificationToken.getCredential().getIsAccountNoLocked())
                            .isCredentialsNonExpired(verificationToken.getCredential().getIsCredentialsNonExpired())
                            .build()
            );
        }
        return verificatationTokenDto;
    }
}
