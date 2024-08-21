package com.doctorhoai.user_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressDto implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long addressId;
    private String fullAddress;
    private String postalCode;
    private String city;
    @JsonProperty( namespace = "user")
    @JsonInclude( value = JsonInclude.Include.NON_NULL)
    private UserDto userDto;
}
