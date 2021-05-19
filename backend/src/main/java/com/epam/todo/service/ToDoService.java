package com.epam.todo.service;

import com.epam.todo.model.ToDo;
import com.epam.todo.repository.ToDoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoJpaRepository toDoJpaRepository;

    public ToDoService(ToDoJpaRepository toDoJpaRepository) {
        this.toDoJpaRepository = toDoJpaRepository;
    }

    public List<ToDo> getToDos() {
        return toDoJpaRepository.findAll();
    }
}
