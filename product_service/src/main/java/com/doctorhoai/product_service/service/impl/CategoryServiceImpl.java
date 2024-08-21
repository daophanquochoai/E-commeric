package com.doctorhoai.product_service.service.impl;

import com.doctorhoai.product_service.dto.CategoryDto;
import com.doctorhoai.product_service.entity.Category;
import com.doctorhoai.product_service.exception.CategoryNotFound;
import com.doctorhoai.product_service.hepler.CategoryMapper;
import com.doctorhoai.product_service.hepler.ProductMapper;
import com.doctorhoai.product_service.repository.CategoryRepository;
import com.doctorhoai.product_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    @Override
    public List<CategoryDto> findAll() {
        return repository.findAll().stream()
                .map( category -> CategoryMapper.mapToCategoryDto(category))
                .distinct().collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long categoryId) {
        return CategoryMapper.mapToCategoryDto(repository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFound("Category with categoryId : " + categoryId.toString() + " not found")
        ));
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return CategoryMapper.mapToCategoryDto(repository.save(CategoryMapper.mapToCategory(categoryDto)));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return CategoryMapper.mapToCategoryDto(repository.save(CategoryMapper.mapToCategory(categoryDto)));
    }

    @Override
    public CategoryDto update(Long categoryId, CategoryDto categoryDto) {
        Optional<Category> categoryOld = repository.findById(categoryId);
        if( categoryOld.isEmpty() ) throw new CategoryNotFound("Category with categoryId : " + categoryId.toString() + " not found");
        if( categoryDto.getCategoryTitle() != null ){
            categoryOld.get().setCategoryTitle(categoryDto.getCategoryTitle());
        }
        if( categoryDto.getParentCategory() != null ){
            categoryOld.get().setParentCategory(CategoryMapper.mapToCategory(categoryDto.getParentCategory()));
        }
        if( categoryDto.getSubCategoriesDto() != null ){
            categoryOld.get().setSubCategories(categoryDto.getSubCategoriesDto().stream().map(
                    cate -> CategoryMapper.mapToCategory(cate)
            ).collect(Collectors.toSet()));
        }
        if( categoryDto.getProductDtos() != null ){
            categoryOld.get().setProducts(
                    categoryDto.getProductDtos().stream().map(
                            pro -> ProductMapper.mapToProduct(pro)
                    ).collect(Collectors.toSet())
            );
        }
        if( categoryDto.getImageUrl() != null ){
            categoryOld.get().setImageUrl(categoryDto.getImageUrl());
        }
        return CategoryMapper.mapToCategoryDto(repository.save(categoryOld.get()));
    }

    @Override
    public void deleteById(Long categoryId) {
        repository.findById(categoryId).orElseThrow(() -> new CategoryNotFound("Category with categoryId : " + categoryId.toString() + " not found")
        );
        repository.deleteById(categoryId);
    }
}
