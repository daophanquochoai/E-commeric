package com.doctorhoai.user_service.dto;

import com.doctorhoai.user_service.entity.RoleBasedAuthority;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CredentialDto implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long credentialId;
    private String username;
    private String password;
    private RoleBasedAuthority roleBasedAuthority;
    private Boolean isEnabled;
    private Boolean isAccountNoExpired;
    private Boolean isAccountNoLocked;
    private Boolean isCredentialsNonExpired;
    @JsonProperty( namespace = "user")
    @JsonInclude( JsonInclude.Include.NON_NULL)
    private UserDto userDto;
    @JsonInclude( JsonInclude.Include.NON_NULL)
    private Set<VerificatationTokenDto> verificationTokens;
}
