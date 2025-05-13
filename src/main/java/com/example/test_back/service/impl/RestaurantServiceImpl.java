package com.example.test_back.service.impl;

import com.example.test_back.dto.reqDto.PostRestaurantRequestDto;
import com.example.test_back.dto.resDto.MenuResponseDto;
import com.example.test_back.dto.resDto.PostRestaurantResponseDto;
import com.example.test_back.dto.resDto.RestaurantResponseDto;
import com.example.test_back.entity.Restaurant;
import com.example.test_back.repository.RestaurantRepository;
import com.example.test_back.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository repository;

    @Override
    public PostRestaurantResponseDto createRestaurant(PostRestaurantRequestDto dto) {
        PostRestaurantResponseDto responseDto = null;

        Restaurant newRestaurant = Restaurant.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .build();

        Restaurant saved = repository.save(newRestaurant);

        responseDto = PostRestaurantResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .address(saved.getAddress())
                .phoneNumber(saved.getPhoneNumber())
                .build();

        return responseDto;
    }

    @Override
    public RestaurantResponseDto getRestaurantById(Long id) {
        RestaurantResponseDto responseDto = null;

        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not Fount Restaurant: " + id));

        List<MenuResponseDto> menus = restaurant.getMenus().stream()
                .map(menu -> MenuResponseDto.builder()
                        .id(menu.getId())
                        .name(menu.getName())
                        .price(menu.getPrice())
                        .description(menu.getDescription())
                        .build()).collect(Collectors.toList());
        responseDto = RestaurantResponseDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .phoneNumber(restaurant.getPhoneNumber())
                .build();

        return responseDto;
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurant() {
        List<RestaurantResponseDto> responseDto = null;

        List<Restaurant> restaurants = repository.findAll();

        responseDto = restaurants.stream()
                .map(restaurant -> RestaurantResponseDto.builder()
                        .id(restaurant.getId())
                        .name(restaurant.getName())
                        .address(restaurant.getAddress())
                        .phoneNumber(restaurant.getPhoneNumber())
                        .build()).collect(Collectors.toList());

        return responseDto;
    }

    @Override
    public void deleteRestaurantById(Long id) {
        Restaurant restaurant = repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Not Found Id: " + id));

        restaurant.getMenus().forEach(restaurant::deleteMenu);

        repository.deleteById(id);
    }
}