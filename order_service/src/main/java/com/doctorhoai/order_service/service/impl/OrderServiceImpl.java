package com.doctorhoai.order_service.service.impl;

import com.doctorhoai.order_service.dto.OrderDto;
import com.doctorhoai.order_service.entity.Order;
import com.doctorhoai.order_service.exception.OrderNotFound;
import com.doctorhoai.order_service.hepler.OrderMapper;
import com.doctorhoai.order_service.repository.OrderRepository;
import com.doctorhoai.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    @Override
    public List<OrderDto> findAll() {
        return repository.findAll().stream().map(
                order -> OrderMapper.mapToOrderDto(order)
        ).collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Long orderId) {
        return OrderMapper.mapToOrderDto(
                repository.findById(orderId).orElseThrow(
                        () -> new OrderNotFound("Order with ID : " + orderId + " not found")
                )
        );
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        return OrderMapper.mapToOrderDto(
                repository.save(OrderMapper.mapToOrder(orderDto))
        );
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        return OrderMapper.mapToOrderDto(
                repository.save(OrderMapper.mapToOrder(orderDto))
        );
    }

    @Override
    public OrderDto update(Long orderId, OrderDto orderDto) {
        Order order = repository.findById(orderId).orElseThrow(   () -> new OrderNotFound("Order with ID : " + orderId + " not found"));
        if( orderDto.getOrderDate() != null ){
            order.setOrderDate(orderDto.getOrderDate());
        }
        if( orderDto.getOrderDesc() != null ){
            order.setOrderDesc(orderDto.getOrderDesc());
        }
        if( orderDto.getOrderFee() != null ){
            order.setOrderFee(orderDto.getOrderFee());
        }
        return OrderMapper.mapToOrderDto(
                repository.save(order)
        );
    }

    @Override
    public void deleteById(Long orderId) {
        repository.findById(orderId).orElseThrow(() -> new OrderNotFound("Order with ID : " + orderId + " not found"));
        repository.deleteById(orderId);
    }
}
