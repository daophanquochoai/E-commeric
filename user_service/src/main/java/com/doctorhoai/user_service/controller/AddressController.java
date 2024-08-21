package com.doctorhoai.user_service.controller;

import com.doctorhoai.user_service.dto.AddressDto;
import com.doctorhoai.user_service.service.AddressService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@Slf4j
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }
    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDto> findById(
            @PathVariable("addressId")
            @NotNull( message = "Input must be not null")
            @Valid Long addressId
    ){
        return ResponseEntity.ok(addressService.findById(addressId));
    }
    @PostMapping()
    public ResponseEntity<AddressDto> save(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid AddressDto addressDto
    ){
        return ResponseEntity.ok(addressService.save(addressDto));
    }
    @PutMapping
    public ResponseEntity<AddressDto> update(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final AddressDto addressDto) {
        return ResponseEntity.ok(this.addressService.update(addressDto));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDto> update(
            @PathVariable("addressId")
            @NotBlank(message = "Input must not blank") final Long addressId,
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final AddressDto addressDto) {
        return ResponseEntity.ok(this.addressService.update(addressId, addressDto));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("addressId") @NotBlank(message = "Input must not blank") @Valid final Long addressId) {
        log.info("*** Boolean, resource; delete address by id *");
        this.addressService.deleteById(addressId);
        return ResponseEntity.ok(true);
    }
}
