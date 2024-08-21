package com.doctorhoai.proxyclient.business.order.controller;


import com.doctorhoai.proxyclient.business.order.service.OrderFeignClient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderFeignClient orderFeignClient;

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findById(
            @PathVariable("orderId")
            @NotNull( message = "Input must not be null" )
            @Valid
            Long orderId
    ){
        return ResponseEntity.ok(orderFeignClient.findById(orderId));
    }
}
