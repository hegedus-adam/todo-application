package com.epam.todo.service;

import com.epam.todo.model.ToDo;
import com.epam.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getTodos() {
        return toDoRepository.findAll();
    }
}
