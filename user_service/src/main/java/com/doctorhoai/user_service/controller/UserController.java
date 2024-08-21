package com.doctorhoai.user_service.controller;

import com.doctorhoai.user_service.dto.UserDto;
import com.doctorhoai.user_service.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/users"})
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(
            @PathVariable("userId")
            @NotNull(message = "Input must not blank")
            @Valid final Long userId) {
        return ResponseEntity.ok(this.userService.findById(userId));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final UserDto userDto) {
        return ResponseEntity.ok(this.userService.save(userDto));
    }

    @PutMapping
    public ResponseEntity<UserDto> update(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final UserDto userDto) {
        return ResponseEntity.ok(this.userService.update(userDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(
            @PathVariable("userId")
            @NotBlank(message = "Input must not blank") final Long userId,
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final UserDto userDto) {
        log.info("*** UserDto, resource; update user with userId *");
        return ResponseEntity.ok(this.userService.update(userId, userDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("userId") @NotBlank(message = "Input must not blank") @Valid final Long userId) {
        log.info("*** Boolean, resource; delete user by id *");
        this.userService.deleteById(userId);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> findByUsername(
            @PathVariable("username")
            @NotBlank(message = "Input must not blank")
            @Valid final String username) {
        return ResponseEntity.ok(this.userService.findByUsername(username));
    }
}
