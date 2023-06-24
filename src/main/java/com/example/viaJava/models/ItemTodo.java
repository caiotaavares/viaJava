package com.example.viaJava.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "via_java")
public class ItemTodo implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String description;
    private Boolean isComplete;
    private Instant createdAt;
    private Instant updatedAt;

    @Override
    public String toString() {
        return String.format("ItemTodo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}');
    }
}
