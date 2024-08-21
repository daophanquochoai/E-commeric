package com.doctorhoai.user_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table( name = "verification_token")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VerificationToken extends AbtractMapper implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long verificationTokenId;
    private String token;
    @JsonFormat( pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat( pattern = "dd-MM-yyyy")
    private LocalDate expireDate;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "credential_id")
    private Credential credential;
}
