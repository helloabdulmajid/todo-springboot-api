package com.abdulmajid.todo.controller;

import com.abdulmajid.todo.model.Todo;
import com.abdulmajid.todo.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {

        this.todoRepository = todoRepository;
    }


    @GetMapping
    public List<Todo> getTodos() {

        return todoRepository.findAll();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {

        return todoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {

        todoRepository.deleteById(id);

        return "Todo deleted successfully";
    }

    @PutMapping("/{id}")
    public Todo updateTodo(
            @PathVariable Long id,
            @RequestBody Todo updatedTodo
    ) {

        Todo todo = todoRepository
                .findById(id)
                .orElseThrow();

        todo.setText(updatedTodo.getText());

        todo.setCompleted(updatedTodo.isCompleted());

        return todoRepository.save(todo);
    }
}