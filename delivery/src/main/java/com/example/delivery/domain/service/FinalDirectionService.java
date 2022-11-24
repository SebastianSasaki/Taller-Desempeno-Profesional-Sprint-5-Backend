package com.example.delivery.domain.service;

import com.example.delivery.domain.model.FinalDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FinalDirectionService {
    Page<FinalDirection> getAllFinalDirections(Pageable pageable);
    FinalDirection getFinalDirectionsByName(String name);
    FinalDirection getFinalDirectionsById(Long Id);
}
