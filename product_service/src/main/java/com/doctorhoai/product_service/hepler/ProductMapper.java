package com.doctorhoai.product_service.hepler;

import com.doctorhoai.product_service.dto.CategoryDto;
import com.doctorhoai.product_service.dto.ProductDto;
import com.doctorhoai.product_service.entity.Category;
import com.doctorhoai.product_service.entity.Product;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductMapper {
    public static ProductDto mapToProductDto(final Product product){
        ProductDto productDto = ProductDto.builder()
                .productId(product.getProductId())
                .productTitle(product.getProductTitle())
                .imageUrl(product.getImageUrl())
                .sku(product.getSku())
                .priceUnit(product.getPriceUnit())
                .quantity(product.getQuantity())
                .build();
        if( product.getCategory() != null ){
            productDto.setCategoryDto(
                    CategoryDto.builder()
                            .categoryId(product.getProductId())
                            .categoryTitle(product.getProductTitle())
                            .imageUrl(product.getImageUrl())
                            .build()
            );
        }
        return productDto;
    }
    public static Product mapToProduct( final ProductDto productDto){
        Product product = Product.builder()
                .productId(productDto.getProductId())
                .productTitle(productDto.getProductTitle())
                .imageUrl(productDto.getImageUrl())
                .sku(productDto.getSku())
                .priceUnit(productDto.getPriceUnit())
                .quantity(productDto.getQuantity())
                .build();
        if( productDto.getCategoryDto() != null ){
            product.setCategory(
                    Category.builder()
                            .categoryId(productDto.getProductId())
                            .categoryTitle(productDto.getProductTitle())
                            .imageUrl(productDto.getImageUrl())
                            .build()
            );
        }
        return product;
    }
}
