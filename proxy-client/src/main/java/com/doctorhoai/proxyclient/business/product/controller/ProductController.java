package com.doctorhoai.proxyclient.business.product.controller;


import com.doctorhoai.proxyclient.business.product.model.ProductDto;
import com.doctorhoai.proxyclient.business.product.service.ProductClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductClientService productClientService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.productClientService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findById(@PathVariable("productId") final Long productId) {
        return ResponseEntity.ok(this.productClientService.findById(productId).getBody());
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody final ProductDto productDto) {
        return ResponseEntity.ok(this.productClientService.save(productDto).getBody());
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody final ProductDto productDto) {
        return ResponseEntity.ok(this.productClientService.update(productDto).getBody());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> update(@PathVariable("productId") final Long productId,
                                             @RequestBody final ProductDto productDto) {
        return ResponseEntity.ok(this.productClientService.update(productId, productDto).getBody());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("productId") final Long productId) {
        return ResponseEntity.ok(this.productClientService.deleteById(productId).getBody());
    }
}
