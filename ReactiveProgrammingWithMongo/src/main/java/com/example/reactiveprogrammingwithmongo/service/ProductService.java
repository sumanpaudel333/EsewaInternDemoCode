package com.example.reactiveprogrammingwithmongo.service;

import com.example.reactiveprogrammingwithmongo.dto.ProductDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductDto> getProducts();

    Mono<ProductDto> getProductById(String id);

    Flux<ProductDto> getProductByPriceRange(long min, long max);

    Mono<ProductDto> saveProduct(Mono<ProductDto> productDto);

    Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono, String id);

    Mono<Void> deleteProduct(String id);
}
