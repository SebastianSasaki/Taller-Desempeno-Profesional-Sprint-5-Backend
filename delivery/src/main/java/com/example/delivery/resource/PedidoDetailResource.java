package com.example.delivery.resource;

import com.example.delivery.domain.model.Pedido;
import com.example.delivery.domain.model.PedidoDetail;
import com.example.delivery.domain.model.Product;

public class PedidoDetailResource {
    private Long id;
    private Pedido pedido;
    private Product product;
    private int cantidad;

    public Long getId() {
        return id;
    }

    public PedidoDetailResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public PedidoDetailResource setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public PedidoDetailResource setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getCantidad() {
        return cantidad;
    }

    public PedidoDetailResource setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }
}
