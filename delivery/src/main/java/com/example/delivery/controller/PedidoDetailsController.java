package com.example.delivery.controller;

import com.example.delivery.domain.model.Pedido;
import com.example.delivery.domain.model.PedidoDetail;
import com.example.delivery.domain.service.PedidoDetailService;
import com.example.delivery.resource.PedidoDetailResource;
import com.example.delivery.resource.PedidoResource;
import com.example.delivery.resource.SavePedidoDetailResource;
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
public class PedidoDetailsController {
    @Autowired
    private PedidoDetailService pedidoDetailService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get All Pedidos Detail", description = "Get All Pedidos Detail by Pages", tags = {"PedidosDetail"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Pedidos Detail returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/pedidosdetail")
    public Page<PedidoDetailResource> getAllPedidos(Pageable pageable) {
        Page<PedidoDetail> pedidoDetailPage = pedidoDetailService.getAllPedidosDetail(pageable);
        List<PedidoDetailResource> resources = pedidoDetailPage.getContent()
                .stream()
                .map(pedidoDetail -> {
                    return convertToResource(pedidoDetail).setPedido(pedidoDetail.getPedido());
                })
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Pedido Detail by Id", description = "Get Pedido Detail by Id", tags = {"PedidosDetail"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido Detail returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/pedidosdetail/{pedidoId}")
    public PedidoDetailResource getPedidoDetailByPedidoId(@PathVariable Long pedidoId) {
        return convertToResource(pedidoDetailService.getByPedidoId(pedidoId));
    }

    @Operation(summary = "Post Pedido Detail", description = "Create a Pedid Detail", tags = {"PedidosDetail"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido Detail created", content = @Content(mediaType =
                    "application/json"))
    })
    @PostMapping("/pedidosdetail")
    public PedidoDetailResource createPedidoDetail(@Valid @RequestBody SavePedidoDetailResource resource) {
        PedidoDetail pedidoDetail = pedidoDetailService.createPedidoDetail(convertToEntity(resource));
        return convertToResource(pedidoDetail).setPedido(pedidoDetail.getPedido());
    }

    private PedidoDetail convertToEntity(SavePedidoDetailResource resource) {
        return mapper.map(resource, PedidoDetail.class);
    }

    private PedidoDetailResource convertToResource(PedidoDetail pedidoDetail) {
        return mapper.map(pedidoDetail, PedidoDetailResource.class);
    }
}
