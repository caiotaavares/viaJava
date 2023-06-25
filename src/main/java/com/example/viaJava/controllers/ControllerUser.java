package com.example.viaJava.controllers;

import com.example.viaJava.models.User;
import com.example.viaJava.services.ItemTodoServices;
import com.example.viaJava.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerUser {

    @Autowired
    private UserServices userServices;
    @Autowired
    private ItemTodoServices itemService;

    @GetMapping("/register-user")
    public String showCreateForm(User user) {
        return "register-user";
    }

    @PostMapping("/register")
    public String register(User user) {

        User newUser = new User();
        userServices.save(user);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(User user) {
        User userLogin = userServices.login(user.getName(), user.getPassword());

        if (userLogin !=  null) {
            return "redirect:/home";
        }

        return null;
    }
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("todoItems", itemService.getAll());
        return modelAndView;
    }
}
