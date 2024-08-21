package com.doctorhoai.user_service.helper;

import com.doctorhoai.user_service.dto.AddressDto;
import com.doctorhoai.user_service.dto.UserDto;
import com.doctorhoai.user_service.entity.Address;
import com.doctorhoai.user_service.entity.Users;

public class AddressMapper {
    public static AddressDto mapToAddressDto(final Address address){
        AddressDto addressDto = AddressDto.builder()
                .addressId(address.getAddressId())
                .fullAddress(address.getFullAddress())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .build();
        if( address.getUser() != null ){
            addressDto.setUserDto(
                    UserDto.builder()
                            .userId(address.getUser().getUserId())
                            .firstName(address.getUser().getFirstName())
                            .lastName(address.getUser().getLastName())
                            .imageUrl(address.getUser().getImageUrl())
                            .email(address.getUser().getEmail())
                            .phone(address.getUser().getPhone())
                            .build()
            );
        }
        return addressDto;
    }

    public static Address mapToAddress(final AddressDto addressDto){
        Address address = Address.builder()
                .addressId(addressDto.getAddressId())
                .fullAddress(addressDto.getFullAddress())
                .postalCode(addressDto.getPostalCode())
                .city(addressDto.getCity())
                .build();
        if( addressDto.getUserDto() != null ){
            address.setUser(
                    Users.builder()
                            .userId(addressDto.getUserDto().getUserId())
                            .firstName(addressDto.getUserDto().getFirstName())
                            .lastName(addressDto.getUserDto().getLastName())
                            .imageUrl(addressDto.getUserDto().getImageUrl())
                            .email(addressDto.getUserDto().getEmail())
                            .phone(addressDto.getUserDto().getPhone())
                            .build()
            );
        }
        return address;
    }
}
