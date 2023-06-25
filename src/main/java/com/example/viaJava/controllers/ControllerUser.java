package com.example.viaJava.controllers;

import ch.qos.logback.core.model.Model;
import com.example.viaJava.models.ItemTodo;
import com.example.viaJava.models.User;
import com.example.viaJava.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerUser {

    @Autowired
    private UserServices userServices;

    @GetMapping("/register-user")
    public String showCreateForm(User user) {
        return "register-user";
    }

    @GetMapping("/register")
    public String register(User user) {

        User newUser = new User();
        userServices.save(user);

        return "redirect:/";
    }
}
