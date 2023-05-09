package com.example.multipledatabaseconnectiontask.inventorydb.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String name;
    private String code;
    private double quantity;
    private double price;
}
