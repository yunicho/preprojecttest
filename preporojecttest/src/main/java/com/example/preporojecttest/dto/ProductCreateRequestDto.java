package com.example.preporojecttest.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //keep the data private and use Getter to update in Dto
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductCreateRequestDto {
    private String name;
    private int qty;
    private Long price;

    @Builder
    public ProductCreateRequestDto(String name, int qty, Long price) {
        this.name =name;
        this.qty =qty;
        this.price =price;
}
}
