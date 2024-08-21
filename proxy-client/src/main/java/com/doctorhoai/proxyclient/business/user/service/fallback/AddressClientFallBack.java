package com.doctorhoai.proxyclient.business.user.service.fallback;

import com.doctorhoai.proxyclient.business.user.model.AddressDto;
import com.doctorhoai.proxyclient.business.user.service.AddressClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressClientFallBack implements AddressClientService {
    @Override
    public ResponseEntity<List<AddressDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<AddressDto> findById(Long addressId) {
        return null;
    }

    @Override
    public ResponseEntity<AddressDto> save(AddressDto addressDto) {
        return null;
    }

    @Override
    public ResponseEntity<AddressDto> update(AddressDto addressDto) {
        return null;
    }

    @Override
    public ResponseEntity<AddressDto> update(Long addressId, AddressDto addressDto) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long addressId) {
        return null;
    }
}
