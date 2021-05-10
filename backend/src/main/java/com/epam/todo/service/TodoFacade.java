package com.epam.todo.service;

import com.epam.todo.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoFacade {

    private  final  ToDoService toDoService;

    public TodoFacade(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public List<ToDo> getTodos() {
        return toDoService.getTodos();
    }
}
