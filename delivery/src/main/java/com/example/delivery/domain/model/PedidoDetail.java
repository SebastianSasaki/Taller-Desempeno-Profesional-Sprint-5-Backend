package com.example.delivery.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Detalle_Pedido")
public class PedidoDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "starting_direction_id", nullable = false)
    @JsonIgnore
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "final_direction_id", nullable = false)
    @JsonIgnore
    private Product product;

    @Column(nullable = false)
    private int cantidad;

    public Pedido getPedido() {
        return pedido;
    }

    public PedidoDetail setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public PedidoDetail setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getCantidad() {
        return cantidad;
    }

    public PedidoDetail setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }
}
