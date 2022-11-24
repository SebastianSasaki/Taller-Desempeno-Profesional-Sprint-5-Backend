package com.example.delivery.service;

import com.example.delivery.domain.model.Product;
import com.example.delivery.domain.repository.ProductRepository;
import com.example.delivery.domain.service.ProductService;
import com.example.delivery.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(Long Id) {
        return productRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Product not found with Id " + Id));
    }

    @Override
    public Page<Product> getAllProductsByName(String name, Pageable pageable) {
        return productRepository.findByName(name, pageable);
    }

    @Override
    public Page<Product> getAllProductsByCost(double cost, Pageable pageable) {
        return productRepository.findByCost(cost, pageable);
    }
}
