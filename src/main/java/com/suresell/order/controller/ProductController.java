package com.suresell.order.controller;

import com.suresell.order.model.Product;
import com.suresell.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> findAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> findByCategory(@PathVariable String categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/get/{productId}")
    public Product productById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String categoryId) {

        if ((productName == null || productName.trim().isEmpty()) && categoryId != null) {
            return productService.getProductsByCategory(categoryId);
        }

        if (productName != null && !productName.trim().isEmpty()) {
            if (categoryId != null && !categoryId.trim().isEmpty()) {
                return productService.searchProductsByCategoryAndName(productName.trim(), categoryId);
            } else {
                return productService.searchProductsByName(productName.trim());
            }
        }

        return productService.getAllProducts();
    }
}
