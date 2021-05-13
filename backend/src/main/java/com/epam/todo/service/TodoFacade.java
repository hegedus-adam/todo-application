package com.epam.todo.service;

import com.epam.todo.model.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoFacade {

    private final ToDoService toDoService;

    public TodoFacade(ToDoService toDoService) {
        Objects.requireNonNull(toDoService);
        this.toDoService = toDoService;
    }

    public ResponseEntity<List<ToDo>> getTodos() {
        return new ResponseEntity<>(toDoService.getTodos(), HttpStatus.OK);
    }
}
