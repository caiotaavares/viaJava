package com.example.viaJava.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Itens")
public class ItemTodo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private LocalDateTime departure;
    private Integer departurePrice;
    private LocalDateTime arrival;
    private LocalDateTime returnDate;
    private Integer returnPrice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_todo_id")
    private List<Task> tasks = null;

    @NotBlank(message = "É necessário uma descrição!")
    private String description;
    private Boolean isComplete = false;
    private Instant createdAt;
    private Instant updatedAt;
    private Integer hostingPrice;

    private Integer totalPrice;

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
