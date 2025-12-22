package com.lam.ProductManagement.repository;

import com.lam.ProductManagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Find products by category
    List<Product> findByCategory(String category);

    // Find products with price less than or equals to maxPrice
    List<Product> findByPriceLessThanEqual(Double maxPrice);

    // Find products containing name (case insensitive)
    List<Product> findByNameContainingIgnoreCase(String name);
}
