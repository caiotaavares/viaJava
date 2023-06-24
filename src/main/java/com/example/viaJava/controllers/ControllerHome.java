package com.example.viaJava.controllers;

import com.example.viaJava.services.ItemTodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControllerHome {

    @Autowired
    private ItemTodoServices itemService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("items", itemService.getAll());
        return modelAndView;
    }
}
