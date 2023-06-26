package com.example.viaJava.services;

import com.example.viaJava.models.User;
import com.example.viaJava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.example.viaJava.helpers.helpers.encryptPassword;

/**
 * Lógica de negócio e comunicação com
 * o banco de Usuários
 */
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

}
