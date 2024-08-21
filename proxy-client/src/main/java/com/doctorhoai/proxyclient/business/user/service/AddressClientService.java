package com.doctorhoai.proxyclient.business.user.service;

import com.doctorhoai.proxyclient.business.user.model.AddressDto;
import com.doctorhoai.proxyclient.business.user.service.fallback.AddressClientFallBack;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient( name = "apigateway", contextId = "gatewayAddress" ,path = "/doctorhoai/user/api/address", fallback = AddressClientFallBack.class)
public interface AddressClientService {
    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll();
    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDto> findById(
            @PathVariable("addressId")
            @NotNull( message = "Input must be not null")
            @Valid Long addressId
    );
    @PostMapping()
    public ResponseEntity<AddressDto> save(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid AddressDto addressDto
    );
    @PutMapping
    public ResponseEntity<AddressDto> update(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final AddressDto addressDto);

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDto> update(
            @PathVariable("addressId")
            @NotBlank(message = "Input must not blank") final Long addressId,
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final AddressDto addressDto);

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("addressId") @NotBlank(message = "Input must not blank") @Valid final Long addressId);
}
