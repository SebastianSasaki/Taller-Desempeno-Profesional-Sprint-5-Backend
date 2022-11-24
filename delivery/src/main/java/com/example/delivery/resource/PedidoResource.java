package com.example.delivery.resource;

import com.example.delivery.domain.model.FinalDirection;
import com.example.delivery.domain.model.Pedido;
import com.example.delivery.domain.model.StartingDirection;

public class PedidoResource {
    private Long id;

    private StartingDirection startingDirection;

    private FinalDirection finalDirection;

    public Long getId() {
        return id;
    }

    public PedidoResource setId(Long id) {
        this.id = id;
        return this;
    }

    public StartingDirection getStartingDirection() {
        return startingDirection;
    }

    public PedidoResource setStartingDirection(StartingDirection startingDirection) {
        this.startingDirection = startingDirection;
        return this;
    }

    public FinalDirection getFinalDirection() {
        return finalDirection;
    }

    public PedidoResource setFinalDirection(FinalDirection finalDirection) {
        this.finalDirection = finalDirection;
        return this;
    }
}
