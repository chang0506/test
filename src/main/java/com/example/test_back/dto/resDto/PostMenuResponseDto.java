package com.example.test_back.dto.resDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostMenuResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private RestaurantResponseDto restaurant;
}
