package com.doctorhoai.product_service.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table( name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true, exclude = {"category"})
public class Product extends AbtractMapped implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "product_id", unique = true, nullable = false, updatable = false)
    private Long productId;
    private String productTitle;
    private String imageUrl;
    @Column( unique = true)
    private String sku;
    @Column( name = "price_unit", columnDefinition = "decimal")
    private Double priceUnit;
    @Column( name = "quantity")
    private Integer quantity;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "categoryId")
    private Category category;
}
