package com.example.viaJava.services;

import com.example.viaJava.models.ItemTodo;
import com.example.viaJava.repositories.ItemTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ItemTodoServices {

    @Autowired
    private ItemTodoRepository itemTodoRepository;

    public Iterable<ItemTodo> getAll() {
        return itemTodoRepository.findAll();
    }

    public Optional<ItemTodo> getById(Long id) {
        return itemTodoRepository.findById(id);
    }

    public void save(ItemTodo item) {
        if (item.getId() == null) {
            item.setCreatedAt(Instant.now());
        }

        item.setUpdatedAt(Instant.now());
        itemTodoRepository.save(item);
    }

    public void delete(ItemTodo item) {
        itemTodoRepository.delete(item);
    }
}
