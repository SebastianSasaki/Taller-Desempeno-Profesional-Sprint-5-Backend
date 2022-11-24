package com.example.delivery.domain.repository;

import com.example.delivery.domain.model.StartingDirection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StartingDirectionRepository extends JpaRepository<StartingDirection, Long> {
    Optional<StartingDirection> findById(Long id);
    StartingDirection findByName(String name);
}
