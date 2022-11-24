package com.example.delivery.controller;

import com.example.delivery.domain.model.FinalDirection;
import com.example.delivery.domain.service.FinalDirectionService;
import com.example.delivery.resource.FinalDirectionResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FinalDirectionsController {
    @Autowired
    private FinalDirectionService finalDirectionService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get All Final Directions", description = "Get All Final Directions by Pages", tags = {"Final Directions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Final Directions returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/final directions")
    public Page<FinalDirectionResource> getAllFinalDirections(Pageable pageable) {
        Page<FinalDirection> finalDirectionPage = finalDirectionService.getAllFinalDirections(pageable);
        List<FinalDirectionResource> resources = finalDirectionPage.getContent()
                .stream()
                .map(finalDirection -> {
                    return convertToResource(finalDirection).setId(finalDirection.getId());
                })
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get FinalDirection By Id", description = "Get FinalDirection by Id", tags = {"Final Directions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Final Direction returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/finaldirections/id/{finalDirectionId}")
    public FinalDirectionResource getFinalDirectionsById(@PathVariable Long finalDirectionId) {
        return convertToResource(finalDirectionService.getFinalDirectionsById(finalDirectionId));
    }

    @Operation(summary = "Get FinalDirection By Name", description = "Get FinalDirection by Name", tags = {"Final Directions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Final Direction returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/finaldirections/name/{finalDirectionName}")
    public FinalDirectionResource getFinalDirectionsByName(@PathVariable String finalDirectionName) {
        return convertToResource(finalDirectionService.getFinalDirectionsByName(finalDirectionName));
    }

    private FinalDirectionResource convertToResource(FinalDirection finalDirection) {
        return mapper.map(finalDirection, FinalDirectionResource.class);
    }
}
