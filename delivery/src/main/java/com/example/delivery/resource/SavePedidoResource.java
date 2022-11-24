package com.example.delivery.resource;

import com.example.delivery.domain.model.FinalDirection;
import com.example.delivery.domain.model.StartingDirection;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SavePedidoResource {
    @NotBlank
    @NotNull
    private StartingDirection startingDirection;

    @NotBlank
    @NotNull
    private FinalDirection finalDirection;

    public StartingDirection getStartingDirection() {
        return startingDirection;
    }

    public SavePedidoResource setStartingDirection(StartingDirection startingDirection) {
        this.startingDirection = startingDirection;
        return this;
    }

    public FinalDirection getFinalDirection() {
        return finalDirection;
    }

    public SavePedidoResource setFinalDirection(FinalDirection finalDirection) {
        this.finalDirection = finalDirection;
        return this;
    }
}
