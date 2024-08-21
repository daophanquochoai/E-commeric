package com.doctorhoai.proxyclient.business.product.service.impl;

import com.doctorhoai.proxyclient.business.product.model.ProductDto;
import com.doctorhoai.proxyclient.business.product.service.ProductClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductClientFallBack implements ProductClientService {
    @Override
    public ResponseEntity<List<ProductDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> findById(Long productId) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> save(ProductDto productDto) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> update(ProductDto productDto) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> update(Long productId, ProductDto productDto) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long productId) {
        return null;
    }
}
