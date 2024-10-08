package com.doctorhoai.shipping_service.entity.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemId implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long productId;
    private Long orderId;

}
