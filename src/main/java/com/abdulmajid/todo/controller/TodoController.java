package com.abdulmajid.todo.controller;

import com.abdulmajid.todo.model.Todo;
import com.abdulmajid.todo.repository.TodoRepository;
import com.abdulmajid.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public List<Todo> getTodos() {

        return todoService.getTodos();
    }

    @PostMapping
    public Todo addTodo(@Valid @RequestBody Todo todo) {

        return todoService.addTodo(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {

        todoService.deleteTodo(id);

        return "Todo deleted successfully";
    }

    @PutMapping("/{id}")
    public Todo updateTodo(
            @Valid
            @PathVariable Long id,
            @RequestBody Todo updatedTodo
    ) {

        return todoService.updateTodo(id, updatedTodo);
    }
}