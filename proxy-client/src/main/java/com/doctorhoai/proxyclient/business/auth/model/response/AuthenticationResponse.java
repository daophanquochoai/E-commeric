package com.doctorhoai.proxyclient.business.auth.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthenticationResponse implements Serializable {
    private final static Long serialVersionUID = 1L;
    private String jwtToken;
}
