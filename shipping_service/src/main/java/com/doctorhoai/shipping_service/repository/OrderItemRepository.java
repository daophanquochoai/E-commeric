package com.doctorhoai.shipping_service.repository;

import com.doctorhoai.shipping_service.entity.OrderItem;
import com.doctorhoai.shipping_service.entity.id.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}
