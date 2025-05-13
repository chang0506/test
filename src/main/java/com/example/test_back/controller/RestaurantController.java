package com.example.test_back.controller;

import com.example.test_back.common.ApiMappingPattern;
import com.example.test_back.dto.reqDto.PostRestaurantRequestDto;
import com.example.test_back.dto.resDto.PostRestaurantResponseDto;
import com.example.test_back.dto.resDto.RestaurantResponseDto;
import com.example.test_back.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.RESTAURANT_API)
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<PostRestaurantResponseDto> createRestaurant(@Valid @RequestBody PostRestaurantRequestDto dto) {
        PostRestaurantResponseDto restaurant = restaurantService.createRestaurant(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> getRestaurantById(@PathVariable Long id) {
        RestaurantResponseDto restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurant() {
        List<RestaurantResponseDto> restaurant = restaurantService.getAllRestaurant();
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurantById(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.noContent().build();
    }




}
