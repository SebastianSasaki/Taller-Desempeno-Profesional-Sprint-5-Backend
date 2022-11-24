package com.example.delivery.domain.service;

import com.example.delivery.domain.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoService {
    Page<Pedido> getAllPedidos(Pageable pageable);
    Pedido getByPedidoById(Long id);
    Pedido createAPedido(Pedido pedido);
}
