package com.epam.todo.repository;

import com.epam.todo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoJpaRepository extends JpaRepository<ToDo, String> {
}
