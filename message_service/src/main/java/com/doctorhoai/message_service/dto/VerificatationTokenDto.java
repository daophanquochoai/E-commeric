package com.doctorhoai.message_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VerificatationTokenDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long verificationTokenId;

    private String token;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate expireDate;

    @JsonProperty("credential")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private CredentialDto credentialDto;
}
