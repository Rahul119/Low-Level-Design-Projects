package com.scaler.backendproductservice.Controller;

import com.scaler.backendproductservice.DTOs.ProductDTO;
import org.springframework.web.bind.annotation.*;

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
    public String addNewProduct(@RequestBody ProductDTO  productDTO) {
        return "Adding New Product " + productDTO;
    }

    public String updateProduct() {
        return "Updating Product";
    }

    public String deleteProduct() {
        return "Deleting Product";
    }
}
