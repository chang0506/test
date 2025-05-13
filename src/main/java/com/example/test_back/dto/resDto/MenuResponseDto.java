package com.example.test_back.dto.resDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MenuResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
}
