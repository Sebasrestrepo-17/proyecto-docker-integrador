package com.app.product.domain;

import java.util.List;

public interface IProductService {
    
    List<Product> findAll();

    Product findById(Long id);

    Product save(Product user);

    Product update(Product user, Long id);

    void deleteById(Long id);
}
