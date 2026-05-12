package com.abdulmajid.todo.controller;

import com.abdulmajid.todo.dto.TodoRequest;
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
    public Todo addTodo(@Valid @RequestBody TodoRequest todoRequest) {

        return todoService.addTodo(todoRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {

        todoService.deleteTodo(id);

        return "Todo deleted successfully";
    }

    @PutMapping("/{id}")
    public Todo updateTodo(

            @PathVariable Long id,

            @Valid @RequestBody TodoRequest updatedTodo
    ) {

        return todoService.updateTodo(id, updatedTodo);
    }
}