package com.doctorhoai.proxyclient.business.user.controller;

import com.doctorhoai.proxyclient.business.user.model.AddressDto;
import com.doctorhoai.proxyclient.business.user.service.AddressClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressClientService addressClientService;
    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll() {
        return ResponseEntity.ok(
                this.addressClientService.findAll() != null ?
                        this.addressClientService.findAll().getBody() : null
        );
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDto> findById(@PathVariable("addressId") final Long addressId) {
        return ResponseEntity.ok(
                this.addressClientService.findById(addressId) != null ?
                        this.addressClientService.findById(addressId).getBody() : null
        );
    }

    @PostMapping
    public ResponseEntity<AddressDto> save(@RequestBody final AddressDto addressDto) {
        return ResponseEntity.ok(
                this.addressClientService.save(addressDto) != null ?
                        this.addressClientService.save(addressDto).getBody() : null
        );
    }

    @PutMapping
    public ResponseEntity<AddressDto> update(@RequestBody final AddressDto addressDto) {
        return ResponseEntity.ok(
                this.addressClientService.update(addressDto) != null ?
                        this.addressClientService.update(addressDto).getBody() : null
        );
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDto> update(@PathVariable("addressId") final String addressId, @RequestBody final AddressDto addressDto) {
        return ResponseEntity.ok(
                this.addressClientService.update(addressDto) != null ?
                        this.addressClientService.update(addressDto).getBody() : null
        );
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("addressId") final Long addressId) {
        return ResponseEntity.ok(
                this.addressClientService.deleteById(addressId) != null ?
                        this.addressClientService.deleteById(addressId).getBody() : null
        );
    }
}
