package com.doctorhoai.user_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Users extends AbtractMapper implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long userId;
    @NotNull( message = "First Name not null")
    private String firstName;
    @NotNull( message = "Last Name not null")
    private String lastName;
    private String imageUrl;
    @Email( message = "Email must be in Email Format")
    private String email;
    private String phone;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Address> addresses;
    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Credential credential;
}
