package com.example.preporojecttest.service;

import com.example.preporojecttest.domain.Product;
import com.example.preporojecttest.dto.ProductCreateRequestDto;
import com.example.preporojecttest.dto.ProductListRequestDto;
import com.example.preporojecttest.dto.ProductUpdateRequestDto;
import com.example.preporojecttest.reepository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service //tell Java it's Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional //deliver data from ProductRepository to Product class
    public Long save(ProductCreateRequestDto productCreateRequestDto) {
        Product product = Product.builder() //bring the builder method in Product class
                .name(productCreateRequestDto.getName())
                .qty(productCreateRequestDto.getQty())
                .price(productCreateRequestDto.getPrice())
                .build();
        //return now saved Dto called product by the matching Id
        return productRepository.save(product).getId();
    }

    @Transactional
    public ProductListRequestDto findProduct(Long id) { //take ProductListReequestDto
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("No such product found")
        ); // if there is no matching id, it throws NullPointException error message
        return ProductListRequestDto.builder()
                .name(product.getName())
                .qty(product.getQty())
                .price(product.getPrice())
                .build();
    }

    @Transactional
    public Long updateProduct(Long id, ProductUpdateRequestDto productUpdateRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("No such product found")
        );
        product.updateProduct(productUpdateRequestDto);
        return productRepository.save(product).getId();
    }

    @Transactional
    public Long removeProduct(Long id) {
        productRepository.deleteById(id);
        return id;
    }
}

