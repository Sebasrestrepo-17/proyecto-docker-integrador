package com.app.product.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.product.domain.Product;
import com.app.product.domain.IProductService;
import com.app.product.domain.Product;

@RestController
@RequestMapping("/api/users")
public class ProductController {

    private final IProductService productServices;

    public ProductController(IProductService productServices) {
        this.productServices = productServices;
    }

    // all users
    @GetMapping
    public ResponseEntity<List<Product>> getAllUsers() {
        List<Product> users = productServices.findAll();
        return ResponseEntity.ok(users);
    }

    // user by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getUserById(@PathVariable Long id) {
        Product user = productServices.findById(id);
        return ResponseEntity.ok(user);
    }

    // create user
    @PostMapping
    public ResponseEntity<Product> createUser(@RequestBody Product user) {
        Product newUser = productServices.save(user);
        return ResponseEntity.ok(newUser);
    }

    // update user
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateUser(@PathVariable Long id, @RequestBody Product user) {
        Product updatedUser = productServices.update(user, id);
        return ResponseEntity.ok(updatedUser);
    }

    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        productServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
