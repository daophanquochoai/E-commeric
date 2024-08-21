package com.doctorhoai.proxyclient.business.product.service;

import com.doctorhoai.proxyclient.business.product.model.ProductDto;
import com.doctorhoai.proxyclient.business.product.service.impl.ProductClientFallBack;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "apigateway", contextId = "gatewayProduct", path = "/doctorhoai/product/api/product", fallback = ProductClientFallBack.class)
public interface ProductClientService {
    @GetMapping
    ResponseEntity<List<ProductDto>> findAll();

    @GetMapping("/{productId}")
    ResponseEntity<ProductDto> findById(
            @PathVariable("productId")
            @NotBlank(message = "Input must not be blank!")
            @Valid final Long productId);

    @PostMapping
    ResponseEntity<ProductDto> save(
            @RequestBody
            @NotNull(message = "Input must not be NULL!")
            @Valid final ProductDto productDto);

    @PutMapping
    ResponseEntity<ProductDto> update(
            @RequestBody
            @NotNull(message = "Input must not be NULL!")
            @Valid final ProductDto productDto);

    @PutMapping("/{productId}")
    ResponseEntity<ProductDto> update(
            @PathVariable("productId")
            @NotBlank(message = "Input must not be blank!")
            @Valid final Long productId,
            @RequestBody
            @NotNull(message = "Input must not be NULL!")
            @Valid final ProductDto productDto);

    @DeleteMapping("/{productId}")
    ResponseEntity<Boolean> deleteById(@PathVariable("productId") final Long productId);

}
