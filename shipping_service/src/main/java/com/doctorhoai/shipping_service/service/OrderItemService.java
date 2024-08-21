package com.doctorhoai.shipping_service.service;

import com.doctorhoai.shipping_service.dto.OrderItemDto;
import com.doctorhoai.shipping_service.entity.id.OrderItemId;

import java.util.List;

public interface OrderItemService {
    List<OrderItemDto> findAll();
    OrderItemDto findById(final OrderItemId orderItemId);
    OrderItemDto save( final OrderItemDto orderItemDto);
    OrderItemDto update( final OrderItemDto orderItemDto);
    void deleteById( final OrderItemId orderItemId);
}
