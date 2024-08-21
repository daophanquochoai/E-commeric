package com.doctorhoai.order_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table( name = "orders" )
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Order extends AbtractMapped implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "order_id", unique = true, nullable = false, updatable = false)
    private Long orderId;
    @JsonSerialize( using = LocalDateSerializer.class)
    @JsonDeserialize( using = LocalDateDeserializer.class)
    @JsonFormat( pattern = "dd-MM-yyyy__HH:mm:ss:SSSSSS", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat( pattern = "dd-MM-yyyy__HH:mm:ss:SSSSSS")
    private LocalDateTime orderDate;
    private String orderDesc;
    @Column( columnDefinition = "decimal")
    private Double orderFee;
    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "card_id")
    private Cart cart;
}
