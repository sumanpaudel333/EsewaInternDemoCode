package com.example.reactiveprogrammingwithmongo.service;

import com.example.reactiveprogrammingwithmongo.dto.ProductDto;
import com.example.reactiveprogrammingwithmongo.repo.ProductRepository;
import com.example.reactiveprogrammingwithmongo.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public Flux<ProductDto> getProducts() {
        return productRepository.findAll().map(AppUtils::convertEntityToDto);
    }

    public Mono<ProductDto> getProductById(String id) {
        return productRepository.findById(id).map(AppUtils::convertEntityToDto);
    }

    public Flux<ProductDto> getProductByPriceRange(long min, long max) {
        return productRepository.findByPriceBetween(Range.closed(min, max));
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDto) {
        return productDto.map(AppUtils::convertDtoToEntity)
                .flatMap(productRepository::insert)
                .map(AppUtils::convertEntityToDto);
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono, String id) {
        return productRepository.findById(id)
                .flatMap(p -> productDtoMono.map(AppUtils::convertDtoToEntity)
                        .doOnNext(e -> e.setId(id))
                        .flatMap(productRepository::save)
                        .map(AppUtils::convertEntityToDto));
    }
    public Mono<Void> deleteProduct(String id){
        return productRepository.deleteById(id);
    }
}
