package com.epam.todo.service;

import com.epam.todo.model.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoFacade {

    private final ToDoService toDoService;

    public TodoFacade(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public ResponseEntity<List<ToDo>> getToDos() {
        return new ResponseEntity<>(toDoService.getToDos(), HttpStatus.OK);
    }
}
