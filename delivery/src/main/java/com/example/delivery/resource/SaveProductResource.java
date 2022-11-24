package com.example.delivery.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveProductResource {
    @NotBlank
    @NotNull
    @Size(max = 250)
    private String name;

    @NotNull
    private double cost;

    public String getName() {
        return name;
    }

    public SaveProductResource setName(String name) {
        this.name = name;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public SaveProductResource setCost(double cost) {
        this.cost = cost;
        return this;
    }
}
