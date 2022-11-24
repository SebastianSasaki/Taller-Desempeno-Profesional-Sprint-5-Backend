package com.example.delivery.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "StartingDirection")
public class StartingDirection implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 250)
    private String name;

    public StartingDirection() {}

    public StartingDirection(@NotBlank String name) {
        this.name = name;
    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public StartingDirection setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StartingDirection setName(String name) {
        this.name = name;
        return this;
    }
}
