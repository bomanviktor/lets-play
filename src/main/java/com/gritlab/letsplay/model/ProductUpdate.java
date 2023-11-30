package com.gritlab.letsplay.model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductUpdate {
    String name;
    String description;
    Double price;
}
