package com.lam.ProductManagement.service;

import com.lam.ProductManagement.model.Product;
import com.lam.ProductManagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductsByCategory(String category) {

                List<Product> categoryWiseProduct = productRepository.findByCategory(category);
        //categoryWiseProduct = null;
        return categoryWiseProduct;
    }

    public List<Product> getProductsByPriceLessThanEqual(Double maxPrice) {
        return productRepository.findByPriceLessThanEqual(maxPrice);
    }

    public List<Product> getProductsByProductName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
