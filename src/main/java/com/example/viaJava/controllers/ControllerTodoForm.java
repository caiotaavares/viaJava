package com.example.viaJava.controllers;

import com.example.viaJava.services.ItemTodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTodoForm {

    @Autowired
    private ItemTodoServices itemService;

    @GetMapping("/new-todo")
    public String showCreateToDoForm() {
        return "new-item";
    }
}
