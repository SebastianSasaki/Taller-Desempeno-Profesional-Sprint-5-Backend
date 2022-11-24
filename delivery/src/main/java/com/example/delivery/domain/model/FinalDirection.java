package com.example.delivery.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "FinalDirection")
public class FinalDirection implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 250)
    private String name;

    public FinalDirection() {}

    public FinalDirection(@NotBlank String name) {
        this.name = name;
    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public FinalDirection setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FinalDirection setName(String name) {
        this.name = name;
        return this;
    }
}
