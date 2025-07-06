package com.scaler.backendproductservice.Controller;

import com.scaler.backendproductservice.DTOs.ProductDTO;
import com.scaler.backendproductservice.Services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping()
    public String getAllProducts() {
        return "Getting All Products";
    }

    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId) {
        return "Getting Single Product with Product Id: " + productId;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDTO  productDTO) {
        return "Adding New Product " + productDTO;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId) {
        return "Updating Product";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting Product";
    }
}
