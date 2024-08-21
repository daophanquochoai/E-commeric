package com.doctorhoai.order_service.service;

import com.doctorhoai.order_service.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAll();
    OrderDto findById(final Long orderId);
    OrderDto save(final OrderDto orderDto);
    OrderDto update(final OrderDto orderDto);
    OrderDto update(final Long orderId, final OrderDto orderDto);
    void deleteById(final Long orderId);
}
