package com.example.delivery.service;

import com.example.delivery.domain.model.StartingDirection;
import com.example.delivery.domain.repository.StartingDirectionRepository;
import com.example.delivery.domain.service.StartingDirectionService;
import com.example.delivery.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StartingDirectionServiceImpl implements StartingDirectionService {
    @Autowired
    private StartingDirectionRepository startingDirectionRepository;

    @Override
    public Page<StartingDirection> getAllStartingDirections(Pageable pageable) {
        return startingDirectionRepository.findAll(pageable);
    }

    @Override
    public StartingDirection getStartingDirectionsByName(String name) {
        return startingDirectionRepository.findByName(name);
    }

    @Override
    public StartingDirection getStartingDirectionsById(Long id) {
        return startingDirectionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Starting Direction not found with Id " + id));
    }
}
