package com.epam.todo.service;

import com.epam.todo.model.ToDosDto;
import com.epam.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDosDto getTodos() {
        return new ToDosDto(toDoRepository.findAll());
    }
}
