package com.doctorhoai.product_service.service;

import com.doctorhoai.product_service.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(final Long categoryId);
    CategoryDto save(final CategoryDto categoryDto);
    CategoryDto update( final CategoryDto categoryDto);
    CategoryDto update( final Long categoryId, final CategoryDto categoryDto);
    void deleteById( final Long categoryId);
}
