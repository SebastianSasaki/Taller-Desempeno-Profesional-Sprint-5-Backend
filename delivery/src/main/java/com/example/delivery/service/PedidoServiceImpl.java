package com.example.delivery.service;

import com.example.delivery.domain.model.Pedido;
import com.example.delivery.domain.repository.PedidoRepository;
import com.example.delivery.domain.service.PedidoService;
import com.example.delivery.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Page<Pedido> getAllPedidos(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    @Override
    public Pedido getByPedidoById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido not found with Id " + id));
    }

    @Override
    public Pedido createAPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
