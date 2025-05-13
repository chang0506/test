package com.example.test_back.controller;

import com.example.test_back.common.ApiMappingPattern;
import com.example.test_back.dto.reqDto.PostMenuRequestDto;
import com.example.test_back.dto.resDto.PostMenuResponseDto;
import com.example.test_back.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiMappingPattern.MENU_API)
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<PostMenuResponseDto> createMenu(@PathVariable Long restaurantId, @Valid @RequestBody PostMenuRequestDto dto) {
        PostMenuResponseDto menu = menuService.createMenu(restaurantId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(menu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuById(@PathVariable Long id) {
        menuService.deleteMenuById(id);
        return ResponseEntity.noContent().build();
    }
}
