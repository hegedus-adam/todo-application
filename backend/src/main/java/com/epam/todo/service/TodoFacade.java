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

  public ResponseEntity<ToDo> createToDo(ToDo toDo) {
    return new ResponseEntity<>(toDoService.createToDo(toDo), HttpStatus.CREATED);
  }

  public ResponseEntity<ToDo> readToDo(String id) {
    return new ResponseEntity<>(toDoService.readToDo(id), HttpStatus.OK);
  }

  public ResponseEntity<ToDo> updateToDo(String id, ToDo toDo) {
    return new ResponseEntity<>(toDoService.updateToDo(id, toDo), HttpStatus.OK);
  }

  public ResponseEntity<String> deleteToDo(String id) {
    toDoService.deleteToDo(id);
    return new ResponseEntity(id, HttpStatus.OK);
  }
}
