package com.doctorhoai.user_service.service;

import com.doctorhoai.user_service.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();
    AddressDto findById( final Long addressId);
    AddressDto save( final AddressDto addressDto);
    AddressDto update( final AddressDto addressDto);
    AddressDto update(final Long addressId, final AddressDto addressDto);
    void deleteById( final Long addressId);
}
