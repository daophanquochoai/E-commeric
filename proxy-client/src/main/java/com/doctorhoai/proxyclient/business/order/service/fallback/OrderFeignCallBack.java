package com.doctorhoai.proxyclient.business.order.service.fallback;

import com.doctorhoai.proxyclient.business.order.model.OrderDto;
import com.doctorhoai.proxyclient.business.order.service.OrderFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderFeignCallBack implements OrderFeignClient {
    @Override
    public ResponseEntity<OrderDto> findById(Long orderId) {
        return null;
    }
}
