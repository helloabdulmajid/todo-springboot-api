package com.abdulmajid.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequest {

    @NotBlank(message = "Task text cannot be empty")
    private String text;

    private boolean completed;
}