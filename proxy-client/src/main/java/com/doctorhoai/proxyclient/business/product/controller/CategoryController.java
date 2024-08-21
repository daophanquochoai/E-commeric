package com.doctorhoai.proxyclient.business.product.controller;

import com.doctorhoai.proxyclient.business.product.model.CategoryDto;
import com.doctorhoai.proxyclient.business.product.service.CategoryClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryClientService categoryClientService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        return ResponseEntity.ok(this.categoryClientService.findAll().getBody());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> findById(@PathVariable("categoryId") final Long categoryId) {
        return ResponseEntity.ok(this.categoryClientService.findById(categoryId).getBody());
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody final CategoryDto categoryDto) {
        return ResponseEntity.ok(this.categoryClientService.save(categoryDto).getBody());
    }

    @PutMapping
    public ResponseEntity<CategoryDto> update(@RequestBody final CategoryDto categoryDto) {
        return ResponseEntity.ok(this.categoryClientService.update(categoryDto).getBody());
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> update(@PathVariable("categoryId") final Long categoryId,
                                              @RequestBody final CategoryDto categoryDto) {
        return ResponseEntity.ok(this.categoryClientService.update(categoryId, categoryDto).getBody());
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("categoryId") final Long categoryId) {
        return ResponseEntity.ok(this.categoryClientService.deleteById(categoryId).getBody());
    }
}
