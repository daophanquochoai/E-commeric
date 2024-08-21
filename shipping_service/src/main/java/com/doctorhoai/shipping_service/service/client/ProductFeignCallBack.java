package com.doctorhoai.shipping_service.service.client;

import com.doctorhoai.shipping_service.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignCallBack implements ProductFeignClient{

    @Override
    public ResponseEntity<ProductDto> findById(Long productId) {
        return null;
    }
}
