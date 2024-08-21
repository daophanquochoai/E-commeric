package com.doctorhoai.product_service.service;

import com.doctorhoai.product_service.dto.ProductDto;
import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById( final Long productId);
    ProductDto save( final ProductDto productDto);
    ProductDto update( final ProductDto productDto);
    ProductDto update(final Long productId, final ProductDto product);
    void deleteById( final Long productId);
}
