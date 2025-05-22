package com.app.product.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.product.domain.Product;
import com.app.product.domain.IProductService;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final IProductService productServices;

    public ProductController(IProductService productServices) {
        this.productServices = productServices;
    }

    // all users
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productServices.findAll();
        return ResponseEntity.ok(products);
    }

    // user by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productServices.findById(id);
        return ResponseEntity.ok(product);
    }

    // create user
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productServices.save(product);
        return ResponseEntity.ok(newProduct);
    }

    // update user
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productServices.update(product, id);
        return ResponseEntity.ok(updatedProduct);
    }

    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
