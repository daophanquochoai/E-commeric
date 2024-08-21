package com.doctorhoai.proxyclient.business.product.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude( JsonInclude.Include.NON_NULL)
@Builder
public class CategoryDto implements Serializable {
    private Long categoryId;
    @NotNull( message = "Field title not null")
    @Min( value = 5, message = "Title too short")
    private String categoryTitle;
    private String imageUrl;
    private Set<CategoryDto> subCategoriesDto;
    private CategoryDto parentCategory;
    private Set<ProductDto> productDtos;
}
