package com.scaler.backendproductservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products")
    public String getAllProducts() {
        return "Getting All Products";
    }

    @GetMapping("/products/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId) {
        return "Getting Single Product with Product Id: " + productId;
    }

    @PostMapping("/products")
    public String addNewProduct() {
        return "Adding New Product with";
    }

    public String updateProduct() {
        return "Updating Product";
    }

    public String deleteProduct() {
        return "Deleting Product";
    }
}
