package com.example.delivery.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SavePedidoDetailResource {
    @NotBlank
    @NotNull
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public SavePedidoDetailResource setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }
}
