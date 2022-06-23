package com.example.preporojecttest.controller;

import com.example.preporojecttest.common.ApiResponse;
import com.example.preporojecttest.dto.ProductCreateRequestDto;
import com.example.preporojecttest.dto.ProductListRequestDto;
import com.example.preporojecttest.dto.ProductUpdateRequestDto;
import com.example.preporojecttest.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//Request post to "localhost:8080/api/create" that is received from productService data

@RestController //tell it is a controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/api/create")
    public ApiResponse createProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto) {
        long retId = productService.save(productCreateRequestDto);
        return ApiResponse.success("result", retId);
    }

    @GetMapping("/api/read/{id}")
    public ApiResponse readProduct(@PathVariable Long id) { //pass the id to call the list
        ProductListRequestDto responseProductDto = productService.findProduct(id);
        return ApiResponse.success("result", responseProductDto); // return if success, the responseProductDto
    }

    @PutMapping("/api/update/{id}")
    public ApiResponse updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto) {
        long retId = productService.updateProduct(id, productUpdateRequestDto);
        return ApiResponse.success("result", retId);
    }

    @DeleteMapping("/api/delete/{id}")
    public ApiResponse deleteProduct(@PathVariable Long id) {
        long retId = productService.removeProduct(id);
        return ApiResponse.success("result", retId);
    }
}
