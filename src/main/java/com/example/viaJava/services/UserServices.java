package com.example.viaJava.services;

import com.example.viaJava.models.ItemTodo;
import com.example.viaJava.models.User;
import com.example.viaJava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User login(String name, String password) {
        String encryptedPassword = encryptPassword(password);

        User user = userRepository.findByNameAndPassword(name, encryptedPassword);
        return user;
    }

    public void save(User user) {
        user.setCreatedAt(Instant.now());
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);

        userRepository.save(user);
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
            return null;
        }
    }
}
