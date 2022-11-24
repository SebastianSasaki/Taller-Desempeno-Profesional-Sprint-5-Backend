package com.example.delivery.domain.service;

import com.example.delivery.domain.model.Pedido;
import com.example.delivery.domain.model.PedidoDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoDetailService {
    Page<PedidoDetail> getAllPedidosDetail(Pageable pageable);
    PedidoDetail getByPedidoId(Long pedidoId);
    PedidoDetail createPedidoDetail(PedidoDetail pedidoDetail);
}
