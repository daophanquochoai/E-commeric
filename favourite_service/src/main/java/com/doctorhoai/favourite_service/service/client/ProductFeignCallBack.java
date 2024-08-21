package com.doctorhoai.favourite_service.service.client;

import com.doctorhoai.favourite_service.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignCallBack implements ProductFeignClient{
    @Override
    public ResponseEntity<ProductDto> findById(Long productId) {
        return null;
    }
}
