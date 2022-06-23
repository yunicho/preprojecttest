package com.example.preporojecttest.reepository;

import com.example.preporojecttest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
