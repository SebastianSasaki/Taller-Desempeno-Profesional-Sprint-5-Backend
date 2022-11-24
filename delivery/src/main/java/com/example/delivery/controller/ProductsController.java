package com.example.delivery.controller;

import com.example.delivery.domain.model.Product;
import com.example.delivery.domain.service.ProductService;
import com.example.delivery.resource.ProductResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductsController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get All Products", description = "Get All Products by Pages", tags = {"Products"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Products returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/products")
    public Page<ProductResource> getAllProducts(Pageable pageable) {
        Page<Product> productPage = productService.getAllProducts(pageable);
        List<ProductResource> resources = productPage.getContent()
                .stream()
                .map(product -> {
                    return convertToResource(product).setId(product.getId());
                })
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Product by Id", description = "Get Product by Id", tags = {"Products"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/products/{productId}")
    public ProductResource getProductById(@PathVariable Long Id) {
        return convertToResource(productService.getProductById(Id));
    }

    private ProductResource convertToResource(Product product) {
        return mapper.map(product, ProductResource.class);
    }
}
