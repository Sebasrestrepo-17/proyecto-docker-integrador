package com.app.product.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.product.domain.Product;
import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.users.domain.IUserRepository;
import com.app.users.domain.IUserService;
import com.app.users.domain.User;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public Product save(Product user) {
        if (productRepository.existsByBrand(user.getBrand())) {
            throw new IllegalArgumentException("email registred: " + user.getBrand());
        }
        return productRepository.save(user);
    }

    @Override
    @Transactional
    public Product update(Product user, Long id) {
        Product existingUser = findById(id);
        existingUser.setName(user.getName());
        existingUser.setBrand(user.getBrand());
        return productRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Product user = findById(id);
        productRepository.delete(user);
    }
}
