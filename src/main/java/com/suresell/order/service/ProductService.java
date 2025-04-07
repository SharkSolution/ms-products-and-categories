package com.suresell.order.service;

import com.suresell.order.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String categoryId);
    Product getProductById(String productId);
}
