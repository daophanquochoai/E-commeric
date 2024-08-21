package com.doctorhoai.user_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address extends AbtractMapper implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( updatable = false)
    private Long addressId;
    private String fullAddress;
    private String postalCode;
    private String city;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
