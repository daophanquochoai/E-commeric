package com.doctorhoai.proxyclient.business.order.model;

import com.doctorhoai.proxyclient.business.product.model.ProductDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {
    @NotNull(message = "Product ID not null")
    private Long productId;
    @NotNull( message = "Order ID not null")
    private Long orderId;
    @Min( value = 0, message = "Quantity large than 0")
    private Long quantity;
    @JsonProperty("product")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProductDto productDto;

    @JsonProperty("order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OrderDto orderDto;
}
