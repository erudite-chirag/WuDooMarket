package com.example.ProductService.controllers;

import com.example.ProductService.entities.Product;
import com.example.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Product getOne(@PathVariable int productId) {
        return productService.getOne(productId);
    }

    @GetMapping("/user/{userId}")
    public List<Product> getProductsofUser(@PathVariable int userId){
        return productService.getProductsOfUser(userId);
    }

}
