package com.abdulmajid.todo.service;

import com.abdulmajid.todo.dto.TodoRequest;
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
    public Todo addTodo(TodoRequest todoRequest) {
        Todo todo = new Todo();

        todo.setText(todoRequest.getText());

        todo.setCompleted(todoRequest.isCompleted());

        return todoRepository.save(todo);

    }
    public void deleteTodo(Long id) {

        todoRepository.deleteById(id);
    }
    public Todo updateTodo(Long id, TodoRequest updatedTodo) {

        Todo todo = todoRepository
                .findById(id)
                .orElseThrow();

        todo.setText(updatedTodo.getText());

        todo.setCompleted(updatedTodo.isCompleted());

        return todoRepository.save(todo);
    }

}