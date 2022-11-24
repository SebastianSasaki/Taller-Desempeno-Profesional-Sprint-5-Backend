package com.example.delivery.domain.service;

import com.example.delivery.domain.model.StartingDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StartingDirectionService {
    Page<StartingDirection> getAllStartingDirections(Pageable pageable);
    StartingDirection getStartingDirectionsByName(String name);
    StartingDirection getStartingDirectionsById(Long Id);
}
