package com.epam.todo.repository;

import com.epam.todo.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoRepository {

    private final ToDoJpaRepository toDoJpaRepository;

    public ToDoRepository(ToDoJpaRepository toDoJpaRepository) {
        this.toDoJpaRepository = toDoJpaRepository;
    }

    public List<ToDo> findAll() {
        return toDoJpaRepository.findAll();
    }
}
