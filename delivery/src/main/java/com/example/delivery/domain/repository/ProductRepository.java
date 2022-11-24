package com.example.delivery.domain.repository;

import com.example.delivery.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long Id);
    Page<Product> findByName(String name, Pageable pageable);
    Page<Product> findByCost(double cost, Pageable pageable);
}
