package com.suresell.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "id_product")
    private String idProduct;

    @Column(name = "name_product", nullable = false)
    private String nameProduct;

    private int price;

    private boolean active;

    @Column(name = "category_id")
    private String categoryId;
}
