package com.example.multipledatabaseconnectiontask.inventorydb.service;

import com.example.multipledatabaseconnectiontask.inventorydb.model.Product;
import com.example.multipledatabaseconnectiontask.inventorydb.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;
    private Product product;

    @Test
    public void convertCsvFilePathDataIntoProduct_testingCsvFileConversionIntoProduct_true() {

    }
}
