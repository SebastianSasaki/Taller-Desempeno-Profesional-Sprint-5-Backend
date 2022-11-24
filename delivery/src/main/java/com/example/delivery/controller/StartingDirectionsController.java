package com.example.delivery.controller;

import com.example.delivery.domain.model.StartingDirection;
import com.example.delivery.domain.service.StartingDirectionService;
import com.example.delivery.resource.StartingDirectionResource;
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
public class StartingDirectionsController {
    @Autowired
    private StartingDirectionService startingDirectionService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get All Starting Directions", description = "Get All Starting Directions by Pages", tags = {"Starting Directions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Starting Directions returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/starting directions")
    public Page<StartingDirectionResource> getAllStartingDirections(Pageable pageable) {
        Page<StartingDirection> startingDirectionPage = startingDirectionService.getAllStartingDirections(pageable);
        List<StartingDirectionResource> resources = startingDirectionPage.getContent()
                .stream()
                .map(startingDirection -> {
                    return convertToResource(startingDirection).setId(startingDirection.getId());
                })
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get StartingDirection By Id", description = "Get StartingDirection by Id", tags = {"Starting Directions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Starting Direction returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/starting directions/id/{startingDirectionId}")
    public StartingDirectionResource getStartingDirectionsById(@PathVariable Long startingDirectionId) {
        return convertToResource(startingDirectionService.getStartingDirectionsById(startingDirectionId));
    }

    @Operation(summary = "Get StartingDirection By Name", description = "Get StartingDirection by Name", tags = {"Starting Directions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Starting Direction returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/starting directions/name/{startingDirectionName}")
    public StartingDirectionResource getStartingDirectionsByName(@PathVariable String startingDirectionName) {
        return convertToResource(startingDirectionService.getStartingDirectionsByName(startingDirectionName));
    }

    private StartingDirectionResource convertToResource(StartingDirection startingDirection) {
        return mapper.map(startingDirection, StartingDirectionResource.class);
    }
}
