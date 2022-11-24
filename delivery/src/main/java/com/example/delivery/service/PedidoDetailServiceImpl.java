package com.example.delivery.service;

import com.example.delivery.domain.model.PedidoDetail;
import com.example.delivery.domain.repository.PedidoDetailRepository;
import com.example.delivery.domain.service.PedidoDetailService;
import com.example.delivery.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoDetailServiceImpl implements PedidoDetailService {
    @Autowired
    private PedidoDetailRepository pedidoDetailRepository;

    @Override
    public Page<PedidoDetail> getAllPedidosDetail(Pageable pageable) {
        return pedidoDetailRepository.findAll(pageable);
    }

    @Override
    public PedidoDetail getByPedidoId(Long pedidoId) {
        return pedidoDetailRepository.findById(pedidoId).orElseThrow(() -> new ResourceNotFoundException("Pedido Detail not found with Id " + pedidoId));
    }

    @Override
    public PedidoDetail createPedidoDetail(PedidoDetail pedidoDetail) {
        return pedidoDetailRepository.save(pedidoDetail);
    }
}
