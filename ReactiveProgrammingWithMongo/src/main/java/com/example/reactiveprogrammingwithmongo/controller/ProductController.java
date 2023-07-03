package com.example.reactiveprogrammingwithmongo.controller;

import com.example.reactiveprogrammingwithmongo.dto.ProductDto;
import com.example.reactiveprogrammingwithmongo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getallproducts")
    public Flux<ProductDto> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/getproductbyid/{id}")
    public Mono<ProductDto> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/getproductbypricerange")
    public Flux<ProductDto> getProductByPriceRange(@RequestParam("min") long min, @RequestParam("max") long max) {
        return productService.getProductByPriceRange(min, max);
    }

    @PostMapping("/addnewproduct")
    public Mono<ProductDto> addNewProduct(@RequestBody Mono<ProductDto> productDto) {
        return productService.saveProduct(productDto);
    }

    @PutMapping("/updateproductbyid/{id}")
    public Mono<ProductDto> updateProductById(@RequestBody Mono<ProductDto> productDtoMono, @PathVariable String id) {
        return productService.updateProduct(productDtoMono, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProductById(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
