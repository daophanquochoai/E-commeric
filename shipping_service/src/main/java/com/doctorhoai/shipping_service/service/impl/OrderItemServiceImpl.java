package com.doctorhoai.shipping_service.service.impl;

import com.doctorhoai.shipping_service.dto.OrderItemDto;
import com.doctorhoai.shipping_service.entity.id.OrderItemId;
import com.doctorhoai.shipping_service.exception.OrderItemNotFound;
import com.doctorhoai.shipping_service.helper.OrderItemMapper;
import com.doctorhoai.shipping_service.repository.OrderItemRepository;
import com.doctorhoai.shipping_service.service.OrderItemService;
import com.doctorhoai.shipping_service.service.client.OrderFeignClient;
import com.doctorhoai.shipping_service.service.client.ProductFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;
    private final OrderFeignClient orderFeignClient;
    private final ProductFeignClient productFeignClient;
    @Override
    public List<OrderItemDto> findAll() {
        return repository.findAll().stream().map(
                OrderItemMapper::mapToOrderItemDto
        ).collect(Collectors.toList());
    }

    @Override
    public OrderItemDto findById(OrderItemId orderItemId) {
        OrderItemDto orderItemDto = OrderItemMapper.mapToOrderItemDto(repository.findById(orderItemId).orElseThrow(
                () -> new OrderItemNotFound("Order Item with ID : " + orderItemId + " not found")
        ));
        orderItemDto.setOrderDto(orderFeignClient.findById(orderItemId.getOrderId()) != null ?
                orderFeignClient.findById(orderItemId.getOrderId()).getBody() : null);
        orderItemDto.setProductDto(productFeignClient.findById(orderItemId.getProductId()) != null ? productFeignClient.findById(orderItemId.getProductId()).getBody() : null);
        return orderItemDto;
    }

    @Override
    public OrderItemDto save(OrderItemDto orderItemDto) {
        log.info("{}",OrderItemMapper.mapToOrderItem(orderItemDto));
        return OrderItemMapper.mapToOrderItemDto(OrderItemMapper.mapToOrderItem(orderItemDto));
    }

    @Override
    public OrderItemDto update(OrderItemDto orderItemDto) {
        return OrderItemMapper.mapToOrderItemDto(OrderItemMapper.mapToOrderItem(orderItemDto));
    }

    @Override
    public void deleteById(OrderItemId orderItemId) {
        repository.findById(orderItemId).orElseThrow(
                () -> new OrderItemNotFound("Order Item with ID : " + orderItemId + " not found")
        );
        repository.deleteById(orderItemId);
    }
}
