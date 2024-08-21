package com.doctorhoai.favourite_service.controller;

import com.doctorhoai.favourite_service.dto.FavouriteDto;
import com.doctorhoai.favourite_service.entity.id.FavouriteId;
import com.doctorhoai.favourite_service.service.FavouriteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/favourite")
@RequiredArgsConstructor
public class FavouriteController {
    private final FavouriteService favouriteService;
    @GetMapping
    public ResponseEntity<List<FavouriteDto>> findAll(){
        return ResponseEntity.ok(favouriteService.findAll());
    }
    @GetMapping("/{userId}/{productId}/{likeDate}")
    public ResponseEntity<FavouriteDto> findById(
            @PathVariable("userId") final Long userId,
            @PathVariable("productId") final Long productId,
            @PathVariable("likeDate") final String likeDate) {
        return ResponseEntity.ok(this.favouriteService.findById(
                new FavouriteId(userId, productId,
                        LocalDateTime.parse(likeDate, DateTimeFormatter.ofPattern("dd-MM-yyyy__HH:mm:ss:SSSSSS")))));
    }

    @GetMapping("/find")
    public ResponseEntity<FavouriteDto> findById(
            @RequestBody
            @NotNull(message = "Input must not be NULL")
            @Valid final FavouriteId favouriteId) {
        return ResponseEntity.ok(this.favouriteService.findById(favouriteId));
    }

    @PostMapping
    public ResponseEntity<FavouriteDto> save(
            @RequestBody
            @NotNull(message = "Input must not be NULL")
            @Valid final FavouriteDto favouriteDto) {
        return ResponseEntity.ok(this.favouriteService.save(favouriteDto));
    }

    @PutMapping
    public ResponseEntity<FavouriteDto> update(
            @RequestBody
            @NotNull(message = "Input must not be NULL")
            @Valid final FavouriteDto favouriteDto) {
        return ResponseEntity.ok(this.favouriteService.update(favouriteDto));
    }

    @DeleteMapping("/{userId}/{productId}/{likeDate}")
    public ResponseEntity<Boolean> deleteById(
            @PathVariable("userId") final Long userId,
            @PathVariable("productId") final Long productId,
            @PathVariable("likeDate") final String likeDate) {
        this.favouriteService.deleteById(new FavouriteId(userId, productId,
                LocalDateTime.parse(likeDate, DateTimeFormatter.ofPattern("dd-MM-yyyy__HH:mm:ss:SSSSSS"))));
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(
            @RequestBody
            @NotNull(message = "Input must not be NULL")
            @Valid final FavouriteId favouriteId) {
        this.favouriteService.deleteById(favouriteId);
        return ResponseEntity.ok(true);
    }
}
