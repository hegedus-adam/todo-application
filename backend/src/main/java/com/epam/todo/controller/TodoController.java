package com.epam.todo.controller;

import com.epam.todo.model.ToDo;
import com.epam.todo.model.UpdateToDo;
import com.epam.todo.service.TodoFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

  private final TodoFacade todoFacade;

  public TodoController(TodoFacade todoFacade) {
    this.todoFacade = todoFacade;
  }

  @Operation(summary = "Download all todos from database")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Given back todos list", content = {@Content(mediaType = "application/json")}),
    @ApiResponse(responseCode = "404", description = "Not available", content = @Content(mediaType = "application/json"))
  })
  @GetMapping("/api/todos")
  @CrossOrigin(origins = "*")
  public ResponseEntity<List<ToDo>> getToDos() {
    return todoFacade.getToDos();
  }

  @Operation(summary = "Create new todo in database")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Create todo by id", content = {@Content(mediaType = "application/json")}),
    @ApiResponse(responseCode = "404", description = "Not available", content = @Content(mediaType = "application/json"))
  })
  @PostMapping("/api/todos")
  @CrossOrigin(origins = "*")
  public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
    return todoFacade.createToDo(toDo);
  }

  @Operation(summary = "Read todo by id from database")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Given back todo by id", content = {@Content(mediaType = "application/json")}),
    @ApiResponse(responseCode = "404", description = "Not available", content = @Content(mediaType = "application/json"))
  })
  @GetMapping("/api/todos/{id}")
  @CrossOrigin(origins = "*")
  public ResponseEntity<ToDo> readToDo(@PathVariable(name = "id") String id) {
    String regex = "^[a-zA-Z0-9]+$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(id);

    if (matcher.matches()) {
      return todoFacade.readToDo(id);
    } else {
      return todoFacade.invalidParameters();
    }
    
  }

  @Operation(summary = "Update todo by id in database")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Update todo by id", content = {@Content(mediaType = "application/json")}),
    @ApiResponse(responseCode = "404", description = "Not available", content = @Content(mediaType = "application/json"))
  })
  @PutMapping("/api/todos/{id}")
  @CrossOrigin(origins = "*")
  public ResponseEntity<ToDo> updateToDo(@PathVariable("id") String id, @RequestBody UpdateToDo updateToDo) {
    return todoFacade.updateToDo(id, updateToDo.createToDo(id));
  }

  @Operation(summary = "Delete todo by id from database")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Delete todo by id", content = {@Content(mediaType = "application/json")}),
    @ApiResponse(responseCode = "404", description = "Not available", content = @Content(mediaType = "application/json"))
  })
  @DeleteMapping("/api/todos/{id}")
  @CrossOrigin(origins = "*")
  public ResponseEntity<String> deleteToDo(@PathVariable(name = "id") String id) {
    return todoFacade.deleteToDo(id);
  }
}
