package com.abdulmajid.todo.service;

import com.abdulmajid.todo.model.Todo;
import com.abdulmajid.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {

        return todoRepository.findAll();
    }
    public Todo addTodo(Todo todo) {

        return todoRepository.save(todo);
    }
    public void deleteTodo(Long id) {

        todoRepository.deleteById(id);
    }
    public Todo updateTodo(Long id, Todo updatedTodo) {

        Todo todo = todoRepository
                .findById(id)
                .orElseThrow();

        todo.setText(updatedTodo.getText());

        todo.setCompleted(updatedTodo.isCompleted());

        return todoRepository.save(todo);
    }

}