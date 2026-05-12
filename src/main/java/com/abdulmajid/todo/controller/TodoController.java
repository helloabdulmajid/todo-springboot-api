package com.abdulmajid.todo.controller;

import com.abdulmajid.todo.dto.TodoRequest;
import com.abdulmajid.todo.model.Todo;
import com.abdulmajid.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {

        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {

        return ResponseEntity.ok(
                todoService.getTodos()
        );
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody TodoRequest todoRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        todoService.addTodo(todoRequest)
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {

        todoService.deleteTodo(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(

            @PathVariable Long id,

            @Valid @RequestBody TodoRequest updatedTodo
    ) {

        return ResponseEntity.ok(
                todoService.updateTodo(id, updatedTodo)
        );
    }
}