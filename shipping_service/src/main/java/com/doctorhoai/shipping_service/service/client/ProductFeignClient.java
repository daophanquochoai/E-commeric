package com.doctorhoai.shipping_service.service.client;

import com.doctorhoai.shipping_service.dto.ProductDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "productservice", fallback = ProductFeignCallBack.class)
public interface ProductFeignClient {
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<ProductDto> findById(
            @PathVariable("productId")
            @NotNull( message = "Input must not be null!!")
            @Valid Long productId
    );
}
