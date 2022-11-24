package com.example.delivery.service;

import com.example.delivery.domain.model.FinalDirection;
import com.example.delivery.domain.repository.FinalDirectionRepository;
import com.example.delivery.domain.service.FinalDirectionService;
import com.example.delivery.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FinalDirectionServiceImpl implements FinalDirectionService {
    @Autowired
    private FinalDirectionRepository finalDirectionRepository;

    @Override
    public Page<FinalDirection> getAllFinalDirections(Pageable pageable) {
        return finalDirectionRepository.findAll(pageable);
    }

    @Override
    public FinalDirection getFinalDirectionsByName(String name) {
        return finalDirectionRepository.findByName(name);
    }

    @Override
    public FinalDirection getFinalDirectionsById(Long id) {
        return finalDirectionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Final Direction not found with Id " + id));
    }
}
