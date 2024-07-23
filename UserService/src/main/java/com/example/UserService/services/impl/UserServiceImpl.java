package com.example.UserService.services.impl;

import com.example.UserService.entities.Product;
import com.example.UserService.entities.User;
import com.example.UserService.repositories.UserRepository;
import com.example.UserService.services.ProductClient;
import com.example.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductClient productClient;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();

        List<User> newUserList =  users.stream().map(user-> {
                user.setProducts(productClient.getProductsOfUser(user.getUserId()));
        return user;
        }).collect(Collectors.toList());

        return newUserList;
//        return userRepository.findAll();
    }

    @Override
    public User getOne(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setProducts(productClient.getProductsOfUser(user.getUserId()));
        return user;
//        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
