package com.example.viaJava.controllers;

import ch.qos.logback.core.model.Model;
import com.example.viaJava.models.ItemTodo;
import com.example.viaJava.services.ItemTodoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

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

        item.setTotalPrice(item.getHostingPrice() + item.getDeparturePrice() + item.getReturnPrice());

        itemService.save(item);

        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {

        ItemTodo item = itemService.getById(id).orElseThrow(() -> new IllegalArgumentException("Erro: Card não encontrado!"));

        itemService.delete(item);

        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, org.springframework.ui.Model model) {

        ItemTodo item = itemService.getById(id).orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", item);
        return "edit-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid ItemTodo itemTodo, BindingResult result, org.springframework.ui.Model model) {

        ItemTodo item = itemService.getById(id).orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        item.setIsComplete(itemTodo.getIsComplete());
        item.setDescription(itemTodo.getDescription());
        itemTodo.setDeparture(item.getDeparture());
        itemTodo.setArrival(item.getArrival());
        itemTodo.setReturnDate(item.getReturnDate());
        itemTodo.setTotalPrice(itemTodo.getHostingPrice() + itemTodo.getDeparturePrice() + itemTodo.getReturnPrice());
        itemService.save(itemTodo);

        return "redirect:/home";
    }

    @ModelAttribute("countries")
    public List<String> getCountries() {
        Locale[] locales = Locale.getAvailableLocales();
        List<String> countries = new ArrayList<>();

        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (!country.isEmpty()) {
                countries.add(country);
            }
        }

        return countries;
    }
}
