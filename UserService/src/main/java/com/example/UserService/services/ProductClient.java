package com.example.UserService.services;

import com.example.UserService.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082", value = "Product-Client")
@FeignClient(name = "ProductService")
public interface ProductClient {

    @GetMapping("/products/user/{userId}")
    List<Product> getProductsOfUser(@PathVariable int userId);
}
