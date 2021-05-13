package com.epam.todo.service;

import com.epam.todo.model.ToDosDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoFacade {

    private final ToDoService toDoService;

    public TodoFacade(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public ResponseEntity<ToDosDto> getTodos() {
        return new ResponseEntity<>(toDoService.getTodos(), HttpStatus.OK);
    }
}
