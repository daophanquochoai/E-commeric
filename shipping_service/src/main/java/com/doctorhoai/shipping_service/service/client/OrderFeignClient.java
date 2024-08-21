package com.doctorhoai.shipping_service.service.client;

import com.doctorhoai.shipping_service.dto.OrderDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient( name = "orderservice", fallback = OrderFeignCallBack.class)
public interface OrderFeignClient {
    @GetMapping("/api/order/{orderId}")
    public ResponseEntity<OrderDto> findById(
            @PathVariable("orderId")
            @NotNull( message = "Input must not be null" )
            @Valid
            Long orderId
    );

}
