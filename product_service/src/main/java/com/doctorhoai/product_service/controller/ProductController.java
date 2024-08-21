package com.doctorhoai.product_service.controller;

import com.doctorhoai.product_service.dto.ProductDto;
import com.doctorhoai.product_service.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Slf4j
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findById(
            @PathVariable("productId")
            @NotNull( message = "Input must not be null!!")
            @Valid Long productId
    ){
        return ResponseEntity.ok(productService.findById(productId));
    }
    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody
            @NotNull( message = "Input must not be null!!")
            @Valid
            ProductDto productDto
    ){
        log.info("{}", productDto);
        return ResponseEntity.ok(productService.save(productDto));
    }
    @PutMapping
    public ResponseEntity<ProductDto> update(
            @RequestBody
            @NotBlank( message = "Input must not be blank !!")
            @Valid final ProductDto productDto
    ){
        return ResponseEntity.ok(productService.update(productDto));
    }
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> update(
            @PathVariable("productId")
            @NotBlank( message = "Input must not be blank!!!")
            @Valid Long productId,
            @RequestBody
            @NotBlank( message = "Input must not be blank!!!")
            @Valid final ProductDto product
    ){
        return ResponseEntity.ok(productService.update(productId, product));
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Boolean> deleteById(
            @PathVariable("productId")
            @NotNull( message = "Input must not be null!!")
            @Valid Long productId
    ){
        productService.deleteById(productId);
        return ResponseEntity.ok(true);
    }
}
