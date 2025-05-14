package com.app.product.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.product.domain.IProductRepository;
import com.app.product.domain.Product;

@Component
public class ProductDatasource {

    private final IProductRepository productRepository;

    public ProductDatasource(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Find all products
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Find product by ID
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Save a product
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // Update a product by ID
    public Optional<Product> update(Product product, Long id) {
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setName(product.getName());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        });
    }

    // Delete product by ID
    public boolean deleteById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
