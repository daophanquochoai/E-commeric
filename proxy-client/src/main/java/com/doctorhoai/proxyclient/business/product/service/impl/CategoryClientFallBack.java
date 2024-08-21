package com.doctorhoai.proxyclient.business.product.service.impl;

import com.doctorhoai.proxyclient.business.product.model.CategoryDto;
import com.doctorhoai.proxyclient.business.product.service.CategoryClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryClientFallBack implements CategoryClientService {
    @Override
    public ResponseEntity<List<CategoryDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDto> findById(Long categoryId) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDto> save(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDto> update(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDto> update(Long categoryId, CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long categoryId) {
        return null;
    }
}
