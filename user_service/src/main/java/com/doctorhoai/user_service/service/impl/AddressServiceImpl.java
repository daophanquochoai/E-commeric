package com.doctorhoai.user_service.service.impl;

import com.doctorhoai.user_service.dto.AddressDto;
import com.doctorhoai.user_service.entity.Address;
import com.doctorhoai.user_service.exception.ObjectNotFound;
import com.doctorhoai.user_service.helper.AddressMapper;
import com.doctorhoai.user_service.repository.AddressRepository;
import com.doctorhoai.user_service.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    @Override
    public List<AddressDto> findAll() {
        return repository.findAll().stream().map(AddressMapper::mapToAddressDto).distinct().collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Long addressId) {
        return AddressMapper.mapToAddressDto(
                repository.findById(addressId).orElseThrow(
                        () -> new ObjectNotFound("Address not found with id : " + addressId)
                )
        );
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        return AddressMapper.mapToAddressDto(
                repository.save(AddressMapper.mapToAddress(addressDto))
        );
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        return AddressMapper.mapToAddressDto(
                repository.save(AddressMapper.mapToAddress(addressDto))
        );
    }

    @Override
    public AddressDto update(Long addressId, AddressDto addressDto) {
        Address addressOld = repository.findById(addressId).orElseThrow(
                        () -> new ObjectNotFound("Address not found with id : " + addressId)
                );
        if( addressDto.getFullAddress() != null ){
            addressOld.setFullAddress(addressDto.getFullAddress());
        }
        if( addressDto.getPostalCode() != null ){
            addressOld.setPostalCode(addressDto.getPostalCode());
        }
        if( addressDto.getCity() != null ){
            addressOld.setCity(addressDto.getCity());
        }
        return AddressMapper.mapToAddressDto(
                repository.save(addressOld)
        );
    }

    @Override
    public void deleteById(Long addressId) {
        repository.findById(addressId).orElseThrow(
                () -> new ObjectNotFound("Address not found with id : " + addressId)
        );
        repository.deleteById(addressId);
    }
}
