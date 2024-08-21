package com.doctorhoai.order_service.controller;


import com.doctorhoai.order_service.dto.CartDto;
import com.doctorhoai.order_service.service.CartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
@Slf4j
public class CartController {
    private final CartService cartService;
    @GetMapping
    public ResponseEntity<List<CartDto>> findAll(){
        return ResponseEntity.ok(cartService.findAll());
    }
    @GetMapping("/{cartId}")
    public ResponseEntity<CartDto> findById(
            @PathVariable("cartId")
            @NotBlank(message = "Input must not be blank")
            @Valid final Long cartId) {
        return ResponseEntity.ok(cartService.findBId(cartId));
    }

    @PostMapping
    public ResponseEntity<CartDto> save(
            @RequestBody
            @NotNull( message = "Input must not null" )
            @Valid CartDto cartDto) {
        log.info("{}", cartDto);
        return ResponseEntity.ok(cartService.save(cartDto));
    }

    @PutMapping
    public ResponseEntity<CartDto> update(
            @RequestBody
            @NotNull(message = "Input must not be NULL")
            @Valid final CartDto cartDto) {
        return ResponseEntity.ok(this.cartService.update(cartDto));
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<CartDto> update(
            @PathVariable("cartId")
            @NotBlank(message = "Input must not be blank")
            @Valid final Long cartId,
            @RequestBody
            @NotNull(message = "Input must not be NULL")
            @Valid final CartDto cartDto) {
        return ResponseEntity.ok(this.cartService.update(cartId, cartDto));
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("cartId") final Long cartId) {
        this.cartService.deleteById(cartId);
        return ResponseEntity.ok(true);
    }

}
