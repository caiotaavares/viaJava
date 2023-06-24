package com.example.viaJava.controllers;

import ch.qos.logback.core.model.Model;
import com.example.viaJava.models.ItemTodo;
import com.example.viaJava.services.ItemTodoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerTodoForm {

    @Autowired
    private ItemTodoServices itemService;

    @GetMapping("/create-todo")
    public String showCreateForm(ItemTodo itemTodo) {
        return "new-item";
    }

    @PostMapping("/todo")
    public String NewTodoItem(@Valid ItemTodo item, BindingResult res, Model model) {

        ItemTodo newItem = new ItemTodo();
        newItem.setDescription(item.getDescription());
        newItem.setIsComplete(item.getIsComplete());

        itemService.save(item);

        return "redirect:/";
    }
}
