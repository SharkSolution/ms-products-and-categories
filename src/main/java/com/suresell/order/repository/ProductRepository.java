package com.suresell.order.repository;

import com.suresell.order.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p WHERE p.categoryId = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") String categoryId);

    // En ProductRepository interface

    @Query("SELECT p FROM Product p WHERE " +
            "LOWER(p.nameProduct) LIKE LOWER(CONCAT('%', :productName, '%')) " +
            "AND p.active = true " +
            "ORDER BY p.nameProduct ASC")
    List<Product> searchProductsByName(@Param("productName") String productName);

    @Query("SELECT p FROM Product p WHERE " +
            "LOWER(p.nameProduct) LIKE LOWER(CONCAT('%', :productName, '%')) " +
            "AND p.categoryId = :categoryId " +
            "AND p.active = true " +
            "ORDER BY p.nameProduct ASC")
    List<Product> searchProductsByCategoryAndName(@Param("productName") String productName,
                                                  @Param("categoryId") String categoryId);
}
