package com.doctorhoai.order_service.hepler;

import com.doctorhoai.order_service.dto.CartDto;
import com.doctorhoai.order_service.dto.OrderDto;
import com.doctorhoai.order_service.entity.Cart;
import com.doctorhoai.order_service.entity.Order;

public class OrderMapper {
    public static OrderDto mapToOrderDto(final Order order){
        OrderDto orderDto = OrderDto.builder()
                .orderId(order.getOrderId())
                .orderDesc(order.getOrderDesc())
                .orderFee(order.getOrderFee())
                .orderDate(order.getOrderDate())
                .build();
        if( order.getCart()!= null ){
            orderDto.setCartDto(
                    CartDto.builder()
                            .cartId(order.getCart().getCartId())
//                            .user
                            .build()
            );
        }
        return orderDto;
    }

    public static Order mapToOrder(final OrderDto orderDto){
        Order order = Order.builder()
                .orderId(orderDto.getOrderId())
                .orderDesc(orderDto.getOrderDesc())
                .orderFee(orderDto.getOrderFee())
                .orderDate(orderDto.getOrderDate())
                .build();
        if( orderDto.getCartDto() != null ){
            order.setCart(
                    Cart.builder()
                            .cartId(order.getCart().getCartId())
//                            .user
                            .build()
            );
        }
        return order;
    }
}
