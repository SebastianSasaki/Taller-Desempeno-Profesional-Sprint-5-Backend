package com.example.delivery.domain.service;

import com.example.delivery.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);

    Product getProductById(Long Id);
    Page<Product> getAllProductsByName(String name, Pageable pageable);
    Page<Product> getAllProductsByCost(double cost, Pageable pageable);
}
