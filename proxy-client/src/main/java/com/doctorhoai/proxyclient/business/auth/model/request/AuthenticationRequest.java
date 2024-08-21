package com.doctorhoai.proxyclient.business.auth.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationRequest implements Serializable {
    private static final Long serialVersionUID = 1L;
    @NotBlank( message = "User must not be empty")
    private String username;
    @NotNull( message = "Password must not be null")
    private String password;
}
