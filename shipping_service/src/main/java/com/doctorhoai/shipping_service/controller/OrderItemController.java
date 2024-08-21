package com.doctorhoai.shipping_service.controller;

import com.doctorhoai.shipping_service.dto.OrderItemDto;
import com.doctorhoai.shipping_service.entity.OrderItem;
import com.doctorhoai.shipping_service.entity.id.OrderItemId;
import com.doctorhoai.shipping_service.service.OrderItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shipping")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemDto>> findAll(){
        return ResponseEntity.ok(orderItemService.findAll());
    }
    @GetMapping("/{orderId}/{productId}")
    public ResponseEntity<OrderItemDto> findById(
            @PathVariable("orderId")
            @NotNull(message = "Input must not be null!!")
            @Valid Long orderId,
            @PathVariable("productId")
            @NotNull(message = "Input must not be null!!")
            @Valid Long productId
    ){
        return ResponseEntity.ok(orderItemService.findById(new OrderItemId(productId,orderId)));
    }
    @GetMapping("/find")
    public ResponseEntity<OrderItemDto> findById(
            @RequestBody
            @NotNull( message = "Input must not be null!!" )
            @Valid final OrderItemId orderItemId
    ){
        return ResponseEntity.ok(orderItemService.findById(orderItemId));
    }
    @PostMapping
    public ResponseEntity<OrderItemDto> save(
            @RequestBody
            @NotNull( message = "Input must not be null!!" )
            @Valid final OrderItemDto orderItemDto
    ){
        return ResponseEntity.ok(orderItemService.save(orderItemDto));
    }

    @PutMapping
    public ResponseEntity<OrderItemDto> update(
            @RequestBody
            @NotNull(message = "Input must not be NULL")
            @Valid final OrderItemDto orderItemDto) {
        return ResponseEntity.ok(this.orderItemService.update(orderItemDto));
    }
    @DeleteMapping("/{orderId}/{productId}")
    public ResponseEntity<Boolean> deleteById(
            @PathVariable("orderId") final Long orderId,
            @PathVariable("productId") final Long productId) {
        this.orderItemService.deleteById(new OrderItemId(orderId, productId));
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(
            @RequestBody
            @NotNull(message = "Input must not be NULL")
            @Valid final OrderItemId orderItemId) {
        this.orderItemService.deleteById(orderItemId);
        return ResponseEntity.ok(true);
    }
}
