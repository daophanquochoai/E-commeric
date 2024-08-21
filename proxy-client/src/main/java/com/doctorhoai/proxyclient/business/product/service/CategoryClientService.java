package com.doctorhoai.proxyclient.business.product.service;


import com.doctorhoai.proxyclient.business.product.model.CategoryDto;
import com.doctorhoai.proxyclient.business.product.service.impl.CategoryClientFallBack;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient( name = "apigateway", contextId = "gatewayCategory", path = "/doctorhoai/product/api/category", fallback = CategoryClientFallBack.class)
public interface CategoryClientService {
    @GetMapping
    ResponseEntity<List<CategoryDto>> findAll();

    @GetMapping("/{categoryId}")
    ResponseEntity<CategoryDto> findById(
            @PathVariable("categoryId")
            @NotBlank(message = "Input must not be blank!")
            @Valid final Long categoryId);

    @PostMapping
    ResponseEntity<CategoryDto> save(
            @RequestBody
            @NotNull(message = "Input must not be NULL!")
            @Valid final CategoryDto categoryDto);

    @PutMapping
    ResponseEntity<CategoryDto> update(
            @RequestBody
            @NotNull(message = "Input must not be NULL!")
            @Valid final CategoryDto categoryDto);

    @PutMapping("/{categoryId}")
    ResponseEntity<CategoryDto> update(
            @PathVariable("categoryId")
            @NotBlank(message = "Input must not be blank!")
            @Valid final Long categoryId,
            @RequestBody
            @NotNull(message = "Input must not be NULL!")
            @Valid final CategoryDto categoryDto);

    @DeleteMapping("/{categoryId}")
    ResponseEntity<Boolean> deleteById(@PathVariable("categoryId") final Long categoryId);

}
