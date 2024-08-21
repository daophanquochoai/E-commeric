package com.doctorhoai.shipping_service.service.client;

import com.doctorhoai.shipping_service.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFeignCallBack implements OrderFeignClient{
    @Override
    public ResponseEntity<OrderDto> findById(Long orderId) {
        return null;
    }
}
