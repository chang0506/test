package com.example.test_back.service.impl;

import com.example.test_back.dto.reqDto.PostMenuRequestDto;
import com.example.test_back.dto.resDto.MenuResponseDto;
import com.example.test_back.dto.resDto.PostMenuResponseDto;
import com.example.test_back.dto.resDto.RestaurantResponseDto;
import com.example.test_back.entity.Menu;
import com.example.test_back.entity.Restaurant;
import com.example.test_back.repository.MenuRepository;
import com.example.test_back.repository.RestaurantRepository;
import com.example.test_back.service.MenuService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public PostMenuResponseDto createMenu(Long restaurantId, PostMenuRequestDto dto) {
        PostMenuResponseDto postMenuResponseDto = null;
        RestaurantResponseDto restaurantResponseDto = null;

        Restaurant restaurant =  restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Not Found id: " + restaurantId));

        Menu newMenu = Menu.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .restaurant(restaurant)
                .build();

        restaurant.addMenu(newMenu);

        Menu savedMenu = menuRepository.save(newMenu);

        restaurantResponseDto = RestaurantResponseDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .phoneNumber(restaurant.getPhoneNumber())
                .build();

        postMenuResponseDto = PostMenuResponseDto.builder()
                .id(savedMenu.getId())
                .name(savedMenu.getName())
                .price(savedMenu.getPrice())
                .description(savedMenu.getDescription())
                .restaurant(restaurantResponseDto)
                .build();

        return postMenuResponseDto;
    }

    @Override
    public PostMenuResponseDto getMenuById(Long id, Long restaurantId) {
        PostMenuResponseDto responseDto = null;

        Restaurant restaurant =  restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Not Found id: " + restaurantId));

        List<MenuResponseDto> menus = restaurant.getMenus().stream()
                .map(menu -> MenuResponseDto.builder()
                        .id(menu.getId())
                        .name(menu.getName())
                        .price(menu.getPrice())
                        .description(menu.getDescription())
                        .build())
                .collect(Collectors.toList());

        responseDto = PostMenuResponseDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())

                .build();


        return null;
    }

    @Override
    public List<PostMenuResponseDto> getAllMenu() {
        return null;
    }

    @Override
    public void deleteMenuById(Long id) {

    }
}
