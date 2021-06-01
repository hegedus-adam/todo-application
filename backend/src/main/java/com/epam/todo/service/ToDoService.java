package com.epam.todo.service;

import com.epam.todo.model.ToDo;
import com.epam.todo.repository.ToDoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoJpaRepository toDoJpaRepository;

    public ToDoService(ToDoJpaRepository toDoJpaRepository) {
        this.toDoJpaRepository = toDoJpaRepository;
    }

    public List<ToDo> getToDos() {
        return toDoJpaRepository.findAll();
    }

    public ToDo createToDo(ToDo toDo) {
        return toDoJpaRepository.save(toDo);
    }

    public ToDo readToDo(long id) {
        Optional<ToDo> result = toDoJpaRepository.findById(id);
        ToDo toDo;
        if (result.isPresent()) {
            toDo = result.get();
        } else {
            throw new NoSuchElementException("Id parameter is not valid: " + id);
        }
        return toDo;
    }

    public ToDo updateToDo(long id, ToDo toDo) {
        checkIds(id, toDo);

        Optional<ToDo> result = toDoJpaRepository.findById(id);
        if (result.isPresent()) {
            toDo.setCreationTimestamp(result.get().getCreationTimestamp());
            toDo = toDoJpaRepository.save(toDo);
        } else {
            throw new NoSuchElementException("Id parameter is not valid: " + id);
        }
        return toDo;
    }

    private void checkIds(long id, ToDo toDo) {
        if (id != toDo.getId()) {
            throw new NoSuchElementException(String.format("Id fields are different: %d %d%n", id, toDo.getId()));
        }
    }

    public void deleteToDo(long id) {
        Optional<ToDo> result = toDoJpaRepository.findById(id);
        ToDo toDo;
        if (result.isPresent()) {
            toDo = result.get();
            toDoJpaRepository.delete(toDo);
        } else {
            throw new NoSuchElementException("Id parameter is not valid: " + id);
        }
    }
}
