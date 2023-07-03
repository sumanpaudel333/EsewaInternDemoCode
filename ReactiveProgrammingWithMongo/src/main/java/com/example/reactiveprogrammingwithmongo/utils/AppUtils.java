package com.example.reactiveprogrammingwithmongo.utils;

import com.example.reactiveprogrammingwithmongo.dto.ProductDto;
import com.example.reactiveprogrammingwithmongo.entity.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static ProductDto convertEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product convertDtoToEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
