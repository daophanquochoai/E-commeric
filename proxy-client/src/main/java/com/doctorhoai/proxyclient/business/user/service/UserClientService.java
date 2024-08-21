package com.doctorhoai.proxyclient.business.user.service;

import com.doctorhoai.proxyclient.business.user.model.UserDto;
import com.doctorhoai.proxyclient.business.user.service.fallback.UserClientFallBack;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "apigateway",contextId = "gatewayuser", path = "/doctorhoai/user/api/users", fallback = UserClientFallBack.class)
public interface UserClientService {

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll();

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(
            @PathVariable("userId")
            @NotNull(message = "Input must not blank")
            @Valid final Long userId);

    @PostMapping
    public ResponseEntity<UserDto> save(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final UserDto userDto);

    @PutMapping
    public ResponseEntity<UserDto> update(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final UserDto userDto);

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(
            @PathVariable("userId")
            @NotBlank(message = "Input must not blank") final Long userId,
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final UserDto userDto);

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("userId") @NotBlank(message = "Input must not blank") @Valid final Long userId);

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> findByUsername(
            @PathVariable("username")
            @NotBlank(message = "Input must not blank")
            @Valid final String username);
}
