package com.example.delivery.domain.repository;

import com.example.delivery.domain.model.FinalDirection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinalDirectionRepository extends JpaRepository<FinalDirection, Long> {
    Optional<FinalDirection> findById(Long id);
    FinalDirection findByName(String name);
}
