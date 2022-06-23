package com.example.preporojecttest.domain;

import com.example.preporojecttest.dto.ProductUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor // creates constructor automatically
public class Product extends Timestamped{
    @Id //Set Id as a primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Id will be automatically generated and increase automatically
    private Long id;

    @Column(nullable = false) // others are just columns and cannot be left empty
    private String name;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    private Long price;

    @Builder //collect clustered columns and tell a product class is constructed as such
    public Product(String name, int qty, Long price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public void updateProduct(ProductUpdateRequestDto productUpdateRequestDto) {
         this.price = productUpdateRequestDto.getPrice();
    }
}
