package com.scaler.backendproductservice.Services;

import com.scaler.backendproductservice.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();


    Product getSingleProduct(Long productId);
    Product addNewProduct(
            String title,
            Double price,
            String description,
            String category,
            String imageUrl
    );
    Product updateProduct(Long productId, Product product);
    boolean deleteProduct(Long productId);

}
