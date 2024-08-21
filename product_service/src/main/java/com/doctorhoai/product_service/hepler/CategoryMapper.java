package com.doctorhoai.product_service.hepler;

import com.doctorhoai.product_service.dto.CategoryDto;
import com.doctorhoai.product_service.entity.Category;

import java.util.Optional;
import java.util.Set;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto(final Category category){
        CategoryDto categoryDto =  CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .categoryTitle(category.getCategoryTitle())
                .imageUrl(category.getImageUrl())
                .build();
        if( category.getParentCategory() != null ){
            categoryDto.setParentCategory(
                    CategoryDto.builder()
                            .categoryId(category.getCategoryId())
                            .categoryTitle(category.getCategoryTitle())
                            .imageUrl(category.getImageUrl())
                            .build()
            );
        }
        return categoryDto;
    }
    public static Category mapToCategory( final CategoryDto categoryDto ){
        Category category =  Category.builder()
                .categoryId(categoryDto.getCategoryId())
                .categoryTitle(categoryDto.getCategoryTitle())
                .imageUrl(categoryDto.getImageUrl())
                .build();
        if( categoryDto.getParentCategory() != null ){
            category.setParentCategory(
                    Category.builder()
                            .categoryId(categoryDto.getCategoryId())
                            .categoryTitle(categoryDto.getCategoryTitle())
                            .imageUrl(categoryDto.getImageUrl())
                            .build()
            );
        }
        return category;
    }
}
