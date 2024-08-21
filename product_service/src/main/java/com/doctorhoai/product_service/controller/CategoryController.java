package com.doctorhoai.product_service.controller;

import com.doctorhoai.product_service.dto.CategoryDto;
import com.doctorhoai.product_service.hepler.CategoryMapper;
import com.doctorhoai.product_service.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@Slf4j
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }
    @PostMapping
    public ResponseEntity<CategoryDto> save(
            @RequestBody
            @NotNull( message = "Input must not be null!!!")
            @Valid final CategoryDto categoryDto
    ){
        log.info("{}", categoryDto);
        return ResponseEntity.ok(categoryService.save(categoryDto) );
    }
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> findById(
            @PathVariable("categoryId")
            @NotNull( message = "Input must be not null !!!")
            @Valid Long categoryId
    ){
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }
    @PutMapping
    public ResponseEntity<CategoryDto> update(
            @RequestBody
            @NotNull( message = "Input must be not null!! " )
            @Valid final CategoryDto categoryDto
    ){
        return ResponseEntity.ok(categoryService.update(categoryDto));
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> update(
            @PathVariable("categoryId")
            @NotNull( message = "Input must not be null!!! ")
            @Valid Long categoryId,
            @RequestBody
            @NotNull( message = "Input must be not null!! " )
            @Valid final CategoryDto categoryDto
    ){
        return ResponseEntity.ok(categoryService.update(categoryId,categoryDto));
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Boolean> deleteById(
            @PathVariable("categoryId")
            @NotNull(message = "Input must not be bull!!")
            @Valid Long categoryId
    ){
        categoryService.deleteById(categoryId);
        return ResponseEntity.ok(true);
    }
}
