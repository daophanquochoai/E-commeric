package com.doctorhoai.order_service.service.impl;

import com.doctorhoai.order_service.dto.CartDto;
import com.doctorhoai.order_service.entity.Cart;
import com.doctorhoai.order_service.exception.CartNoptFound;
import com.doctorhoai.order_service.hepler.CartMapper;
import com.doctorhoai.order_service.repository.CartRepository;
import com.doctorhoai.order_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository repository;
    @Override
    public List<CartDto> findAll() {
        return repository.findAll().stream().map(
                cart -> CartMapper.mapToCartDto(cart)
        ).collect(Collectors.toList());
    }

    @Override
    public CartDto findBId(Long cartId) {
        return CartMapper.mapToCartDto( repository.findById(cartId).orElseThrow( () -> new CartNoptFound("Cart with ID : " + cartId + " not found")) );
    }

    @Override
    public CartDto save(CartDto cartDto) {
        return CartMapper.mapToCartDto(
                repository.save(CartMapper.mapToCart(cartDto))
        );
    }

    @Override
    public CartDto update(CartDto cartDto) {
        return CartMapper.mapToCartDto(
                repository.save(CartMapper.mapToCart(cartDto))
        );
    }

    @Override
    public CartDto update(Long cartId, CartDto cartDto) {
        Cart cart = repository.findById(cartId).orElseThrow( () -> new CartNoptFound("Cart with ID : " + cartId + " not found"));
        if( cartDto.getUserDto() != null ){
            cart.setUserId(cartDto.getUserDto().getUserId());
        }
        return CartMapper.mapToCartDto(
                repository.save(cart)
        );
    }

    @Override
    public void deleteById(Long cartId) {
        repository.findById(cartId).orElseThrow( () -> new CartNoptFound("Cart with ID : " + cartId + " not found"));
        repository.deleteById(cartId);
    }
}
