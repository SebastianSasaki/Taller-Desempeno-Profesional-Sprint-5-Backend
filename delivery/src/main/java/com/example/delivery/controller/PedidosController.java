package com.example.delivery.controller;

import com.example.delivery.domain.model.Pedido;
import com.example.delivery.domain.service.PedidoService;
import com.example.delivery.resource.PedidoResource;
import com.example.delivery.resource.SavePedidoResource;
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

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PedidosController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get All Pedidos", description = "Get All Pedidos by Pages", tags = {"Pedidos"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Pedidos returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/pedidos")
    public Page<PedidoResource> getAllPedidos(Pageable pageable) {
        Page<Pedido> pedidoPage = pedidoService.getAllPedidos(pageable);
        List<PedidoResource> resources = pedidoPage.getContent()
                .stream()
                .map(pedido -> {
                    return convertToResource(pedido).setId(pedido.getId());
                })
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Pedido by Id", description = "Get Pedido by Id", tags = {"Pedidos"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/pedidos/{pedidoId}")
    public PedidoResource getPedidoById(@PathVariable Long Id) {
        return convertToResource(pedidoService.getByPedidoById(Id));
    }

    @Operation(summary = "Post Pedido", description = "Create a Pedido", tags = {"Pedidos"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido created", content = @Content(mediaType =
                    "application/json"))
    })
    @PostMapping("/pedidos")
    public PedidoResource createPedido(@Valid @RequestBody SavePedidoResource resource) {
        Pedido pedido = pedidoService.createAPedido(convertToEntity(resource));
        return convertToResource(pedido).setId(pedido.getId());
    }

    private Pedido convertToEntity(SavePedidoResource resource) {
        return mapper.map(resource, Pedido.class);
    }

    private PedidoResource convertToResource(Pedido pedido) {
        return mapper.map(pedido, PedidoResource.class);
    }
}
