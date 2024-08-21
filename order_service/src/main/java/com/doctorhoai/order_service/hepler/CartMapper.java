package com.doctorhoai.order_service.hepler;

import com.doctorhoai.order_service.dto.CartDto;
import com.doctorhoai.order_service.dto.OrderDto;
import com.doctorhoai.order_service.entity.Cart;
import com.doctorhoai.order_service.entity.Order;

import java.util.stream.Collectors;

public class CartMapper {
    public static CartDto mapToCartDto(final Cart cart){
        CartDto cartDto = CartDto.builder()
                .cartId(cart.getCartId())
                .build();
        if( cart.getOrders() != null ){
            cartDto.setOrderDtos(
                    cart.getOrders().stream().map(
                            order ->
                                    OrderDto.builder()
                                            .orderId(order.getOrderId())
                                            .orderDesc(order.getOrderDesc())
                                            .orderFee(order.getOrderFee())
                                            .orderDate(order.getOrderDate())
                                            .build()
                    ).collect(Collectors.toList())
            );
        }
//        if( cart.getUserId() != null) user ch co
        return cartDto;
    }
    public static Cart mapToCart( final CartDto cartDto){
        Cart cart = Cart.builder()
                .cartId(cartDto.getCartId())
                .userId(cartDto.getUserDto().getUserId())
                .build();
        if( cartDto.getOrderDtos() != null ){
            cart.setOrders(
                    cartDto.getOrderDtos().stream().map(
                            order -> Order.builder()
                                    .orderId(order.getOrderId())
                                    .orderDesc(order.getOrderDesc())
                                    .orderFee(order.getOrderFee())
                                    .orderDate(order.getOrderDate())
                                    .build()
                    ).collect(Collectors.toSet())
            );
        }
        return cart;
    }
}
