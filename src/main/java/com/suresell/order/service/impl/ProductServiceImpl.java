package com.suresell.order.service.impl;

import com.suresell.order.model.Product;
import com.suresell.order.repository.ProductRepository;
import com.suresell.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> searchProductsByName(String productName) {
        return productRepository.searchProductsByName(productName);
    }

    @Override
    public List<Product> searchProductsByCategoryAndName(String productName, String categoryId) {
        return productRepository.searchProductsByCategoryAndName(productName, categoryId);
    }

}
