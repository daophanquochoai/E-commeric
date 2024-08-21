package com.doctorhoai.shipping_service.entity;

import com.doctorhoai.shipping_service.entity.id.OrderItemId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "order_item")
@Entity
@IdClass(OrderItemId.class)
@Builder
public class OrderItem {
    private static final Long serialVersionUID = 1L;
    @Id
    @NotNull( message = "Product ID not null")
    private Long productId;
    @Id
    private Long orderId;
    @Min( value = 0, message = "Value large than 0!!")
    private Long quantity;
}
