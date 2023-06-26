package com.example.viaJava.controllers;

import com.example.viaJava.models.ItemTodo;
import com.example.viaJava.models.User;
import com.example.viaJava.services.ItemTodoServices;
import com.example.viaJava.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador da home
 * Abre a página principal em "/"
 */
@Controller
public class ControllerHome {

    @Autowired
    private ItemTodoServices itemService;

    @Autowired
    private UserServices userServices;

//    @Autowired
//    public ControllerHome(ItemTodoServices itemService, UserServices userServices) {
//        this.itemService = itemService;
//        this.userServices = userServices;
//    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
}
