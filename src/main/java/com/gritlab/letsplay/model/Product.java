package com.gritlab.letsplay.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class Product {
    private @Id String id;
    private String name;
    private String description;
    private double price;
    private String userId;

    public Product(String name, String description, Double price, String userId){
        this.name = name;
        this.description = description;
        this.price = price;
        this.userId = userId;
    }
}