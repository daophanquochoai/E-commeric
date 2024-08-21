package com.doctorhoai.favourite_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FavouriteDto implements Serializable {
    private static final Long serialVersionUID = 1L;
    @NotNull(message = "User ID not null")
    private Long userId;
    @NotNull(message = "Product ID not null")
    private Long productId;
    @NotNull(message = "Like Date not null")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy__HH:mm:ss:SSSSSS", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd-MM-yyyy__HH:mm:ss:SSSSSS")
    private LocalDateTime likeDate;
    @JsonProperty("user")
    @JsonInclude( JsonInclude.Include.NON_NULL)
    private UserDto userDto;
    @JsonProperty("product")
    @JsonInclude( JsonInclude.Include.NON_NULL)
    private ProductDto productDto;
}
