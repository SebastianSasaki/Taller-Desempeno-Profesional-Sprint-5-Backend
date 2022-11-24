package com.example.delivery.domain.repository;

import com.example.delivery.domain.model.PedidoDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoDetailRepository extends JpaRepository<PedidoDetail, Long> {
    Optional<PedidoDetail> findByPedidoId(Long pedidoId);
}
