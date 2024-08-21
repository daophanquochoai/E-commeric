package com.doctorhoai.proxyclient.business.user.controller;

import com.doctorhoai.proxyclient.business.user.model.UserDto;
import com.doctorhoai.proxyclient.business.user.service.UserClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserClientService userClientService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        log.info(" **  {}  ** ", userClientService.findAll());
        return ResponseEntity.ok(
                this.userClientService.findAll() != null ?
                        this.userClientService.findAll().getBody() : null
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable("userId") final Long userId) {
        return ResponseEntity.ok(
                this.userClientService.findById(userId) != null ?
                        this.userClientService.findById(userId).getBody() : null
        );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable("username") final String username) {
        return ResponseEntity.ok(
                this.userClientService.findByUsername(username) != null ?
                        this.userClientService.findByUsername(username).getBody() : null
        );
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody final UserDto userDto) {
        return ResponseEntity.ok(
                this.userClientService.save(userDto) != null ?
                        this.userClientService.save(userDto).getBody() : null
        );
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody final UserDto userDto) {
        return ResponseEntity.ok(
                this.userClientService.update(userDto) != null ?
                        this.userClientService.update(userDto).getBody() : null
        );
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(@PathVariable("userId") final String userId, @RequestBody final UserDto userDto) {
        return ResponseEntity.ok(
                this.userClientService.update(userDto) != null ?
                        this.userClientService.update(userDto).getBody() : null
        );
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("userId") final Long userId) {
        return ResponseEntity.ok(
                this.userClientService.deleteById(userId) != null ?
                        this.userClientService.deleteById(userId).getBody() : null
        );
    }
}
