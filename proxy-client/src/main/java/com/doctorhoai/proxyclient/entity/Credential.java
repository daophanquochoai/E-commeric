package com.doctorhoai.proxyclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credential extends AbtractMapper implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( updatable = false, unique = true, nullable = false)
    private Long credentialId;
    @Column( unique = true )
    private String username;
    @NotNull( message = "Password not null")
    @NotBlank( message = "Password not blank")
    @Length( min = 10, message = "Password should have 10 character")
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleBasedAuthority roleBasedAuthority;
    private Boolean isEnabled;
    private Boolean isAccountNoExpired;
    private Boolean isAccountNoLocked;
    private Boolean isCredentialsNonExpired;
    @JsonIgnore
    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( nullable = false, name = "user_id")
    private Users user;
    @JsonIgnore
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "credential")
    private Set<VerificationToken> verificationTokens;
}
