package com.example.viaJava.repositories;

import com.example.viaJava.models.ItemTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTodoRepository extends JpaRepository<ItemTodo, Long> {
}
