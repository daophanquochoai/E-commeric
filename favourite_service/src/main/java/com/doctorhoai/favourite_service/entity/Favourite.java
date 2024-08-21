package com.doctorhoai.favourite_service.entity;

import com.doctorhoai.favourite_service.entity.id.FavouriteId;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "favourite")
@Data
@Builder
@IdClass(FavouriteId.class)
public class Favourite extends AbtractMapped implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @Column( nullable = false )
    private Long userId;
    @Id
    @Column( nullable = false )
    private Long productId;
    @Id
    @Column( nullable = false)
    @JsonSerialize( using = LocalDateTimeSerializer.class)
    @JsonDeserialize( using = LocalDateTimeDeserializer.class)
    @DateTimeFormat( pattern = "dd-MM-yyyy__HH:mm:ss:SSSSSS")
    private LocalDateTime likeDate;
}
