package com.example.test_back.service;

import com.example.test_back.dto.reqDto.PostRestaurantRequestDto;
import com.example.test_back.dto.resDto.PostRestaurantResponseDto;
import com.example.test_back.dto.resDto.RestaurantResponseDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    PostRestaurantResponseDto createRestaurant(@Valid PostRestaurantRequestDto dto);

    RestaurantResponseDto getRestaurantById(Long id);

    List<RestaurantResponseDto> getAllRestaurant();

    void deleteRestaurantById(Long id);
}
