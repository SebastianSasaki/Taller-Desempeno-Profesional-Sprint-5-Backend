package com.example.delivery.resource;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ProductResource {
    private Long id;
    private String name;
    private double cost;

    public Long getId() {
        return id;
    }

    public ProductResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResource setName(String name) {
        this.name = name;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public ProductResource setCost(double cost) {
        this.cost = cost;
        return this;
    }
}
