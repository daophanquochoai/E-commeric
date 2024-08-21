package com.doctorhoai.order_service.service;

import com.doctorhoai.order_service.dto.CartDto;

import java.util.List;

public interface CartService {
    List<CartDto> findAll();
    CartDto findBId( Long cartId);
    CartDto save( final CartDto cartDto);
    CartDto update( final CartDto cartDto);
    CartDto update(Long cartId, final CartDto cartDto);
    void deleteById( Long cartId);
}
