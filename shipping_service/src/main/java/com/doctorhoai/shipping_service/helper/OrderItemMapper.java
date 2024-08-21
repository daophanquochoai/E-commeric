package com.doctorhoai.shipping_service.helper;

import com.doctorhoai.shipping_service.dto.OrderDto;
import com.doctorhoai.shipping_service.dto.OrderItemDto;
import com.doctorhoai.shipping_service.dto.ProductDto;
import com.doctorhoai.shipping_service.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItemDto mapToOrderItemDto(final OrderItem orderItem){
        return OrderItemDto
                .builder()
                .orderId(orderItem.getOrderId())
                .productId(orderItem.getProductId())
                .quantity(orderItem.getQuantity())
                .productDto(
                        ProductDto.builder()
                                .productId(orderItem.getProductId())
                                .build()
                )
                .orderDto(
                        OrderDto.builder()
                                .orderId(orderItem.getOrderId())
                                .build()
                )
                .build();
    }

    public static OrderItem mapToOrderItem(final OrderItemDto orderItemDto){
        return OrderItem
                .builder()
                .orderId(orderItemDto.getOrderId())
                .productId(orderItemDto.getProductId())
                .quantity(orderItemDto.getQuantity())
                .build();
    }
}
