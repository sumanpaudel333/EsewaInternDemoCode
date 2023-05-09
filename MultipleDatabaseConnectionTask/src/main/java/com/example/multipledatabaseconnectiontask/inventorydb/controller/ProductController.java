package com.example.multipledatabaseconnectiontask.inventorydb.controller;

import com.example.multipledatabaseconnectiontask.inventorydb.dto.ProductDto;
import com.example.multipledatabaseconnectiontask.inventorydb.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<ProductDto> productDto() {
        return productService.getAllProduct();
    }
}
