package com.doctorhoai.order_service.controller;


import com.doctorhoai.order_service.dto.OrderDto;
import com.doctorhoai.order_service.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@Slf4j
public class OrderController{

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> findById(
            @PathVariable("orderId")
            @NotNull( message = "Input must not be null" )
            @Valid
            Long orderId
    ){
        return ResponseEntity.ok(orderService.findById(orderId));
    }
    @PostMapping
    public ResponseEntity<OrderDto> save(
            @RequestBody
            @NotNull( message = "Input must not be null!!!" )
            @Valid
            OrderDto orderDto
    ){
        log.info("{}", orderDto);
        return ResponseEntity.ok(orderService.save(orderDto));
    }
    @PutMapping
    public ResponseEntity<OrderDto> update(
            @RequestBody
            @Valid
            OrderDto orderDto
    ){
        return ResponseEntity.ok(orderService.update(orderDto));
    }
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> update(
            @PathVariable("orderId")
            @NotNull( message = "Input must not be null" )
            @Valid
            Long orderId,
            @RequestBody
            @Valid
            OrderDto orderDto
    ){
        return ResponseEntity.ok(orderService.update(orderId,orderDto));
    }
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Boolean> deleteById(
            @PathVariable("orderId")
            @NotNull( message = "Input must not be null" )
            @Valid
            Long orderId
    ){
        orderService.deleteById(orderId);
        return ResponseEntity.ok(true);
    }
}
