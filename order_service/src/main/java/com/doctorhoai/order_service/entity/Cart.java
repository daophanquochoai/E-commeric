package com.doctorhoai.order_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "carts" )
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cart extends AbtractMapped implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( unique = true, nullable = false, updatable = false)
    private Integer cartId;
    private Integer userId;
    @JsonIgnore
    @OneToMany( mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;
}
