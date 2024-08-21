package com.doctorhoai.proxyclient.business.order.service;

import com.doctorhoai.proxyclient.business.order.model.OrderDto;
import com.doctorhoai.proxyclient.business.order.service.fallback.OrderFeignCallBack;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
