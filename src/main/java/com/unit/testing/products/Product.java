package com.unit.testing.products;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(setterPrefix = "set")
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

}