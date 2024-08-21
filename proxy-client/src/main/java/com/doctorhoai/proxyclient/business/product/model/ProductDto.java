package com.doctorhoai.proxyclient.business.product.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long productId;
    private String productTitle;
    private String imageUrl;
    private String sku;
    private Double priceUnit;
    private Integer quantity;
    @JsonProperty("category")
    @JsonInclude( JsonInclude.Include.NON_NULL)
    private CategoryDto categoryDto;
}
