package com.example.delivery.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "Pedidos")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "starting_direction_id", nullable = false)
    @JsonIgnore
    private StartingDirection startingDirection;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "final_direction_id", nullable = false)
    @JsonIgnore
    private FinalDirection finalDirection;

    public Pedido() {}

    public Pedido(StartingDirection startingDirection, FinalDirection finalDirection) {
        this.startingDirection = startingDirection;
        this.finalDirection = finalDirection;
    }

    public Long getId() {
        return id;
    }

    public Pedido setId(Long id) {
        this.id = id;
        return this;
    }

    public StartingDirection getStartingDirection() {
        return startingDirection;
    }

    public Pedido setStartingDirection(StartingDirection startingDirection) {
        this.startingDirection = startingDirection;
        return this;
    }

    public FinalDirection getFinalDirection() {
        return finalDirection;
    }

    public Pedido setFinalDirection(FinalDirection finalDirection) {
        this.finalDirection = finalDirection;
        return this;
    }
}
