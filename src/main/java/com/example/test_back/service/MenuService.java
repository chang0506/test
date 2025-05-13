package com.example.test_back.service;

import com.example.test_back.dto.reqDto.PostMenuRequestDto;
import com.example.test_back.dto.resDto.PostMenuResponseDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    PostMenuResponseDto createMenu(Long restaurantId, @Valid PostMenuRequestDto dto);

    PostMenuResponseDto getMenuById(Long id, Long restaurantId);

    List<PostMenuResponseDto> getAllMenu();

    void deleteMenuById(Long id);
}
