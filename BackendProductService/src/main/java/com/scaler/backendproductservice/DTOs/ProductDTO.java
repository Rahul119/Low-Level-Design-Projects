package com.scaler.backendproductservice.DTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProductDTO {

    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
