package com.example.viaJava.services;

import com.example.viaJava.models.ItemTodo;
import com.example.viaJava.models.User;
import com.example.viaJava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User login(String name, String password) {
        User user = userRepository.findByNameAndPassword(name, password);
        return user;
    }

    public void save(User user) {
        user.setCreatedAt(Instant.now());
        userRepository.save(user);
    }
}
