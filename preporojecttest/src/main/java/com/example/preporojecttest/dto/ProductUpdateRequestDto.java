package com.example.preporojecttest.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductUpdateRequestDto {
    private Long price;

    @Builder
    public ProductUpdateRequestDto(Long price) {
        this.price = price;
    }
}
