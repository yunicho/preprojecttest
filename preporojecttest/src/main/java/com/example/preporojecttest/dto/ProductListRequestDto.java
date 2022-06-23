package com.example.preporojecttest.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductListRequestDto {
    private String name;
    private int qty;
    private Long price;

    @Builder
    public ProductListRequestDto(String name, int qty, Long price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}
