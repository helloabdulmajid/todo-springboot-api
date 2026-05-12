package com.abdulmajid.todo.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Task text cannot be empty")
    private String text;
    private boolean completed;


}