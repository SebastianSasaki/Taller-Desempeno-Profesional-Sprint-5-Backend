package com.example.delivery.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "Catalogo")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 250)
    private String name;

    @Column(nullable = false, scale = 2)
    private double cost;

    public Product() {}

    public Product(@NotBlank String name, @NotBlank double cost) {
        this.name = name;
        this.cost = cost;
    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public Product setCost(double cost) {
        this.cost = cost;
        return this;
    }
}
