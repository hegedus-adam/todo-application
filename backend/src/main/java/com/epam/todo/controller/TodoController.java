package com.epam.todo.controller;


import com.epam.todo.model.ToDo;
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
            @ApiResponse(responseCode = "200",
                    description = "Given back todos list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/api/todo")
    public ResponseEntity<List<ToDo>> getToDos() {
        return todoFacade.getToDos();
    }

    @Operation(summary = "Create new todo in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Create todo by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/api/todo")
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
        return todoFacade.createToDo(toDo);
    }

    @Operation(summary = "Read todo by id from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Given back todo by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/api/todo/{id}")
    public ResponseEntity<ToDo> readToDo(@PathVariable(name = "id") long id) {
        return todoFacade.readToDo(id);
    }

    @Operation(summary = "Update todo by id in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Update todo by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content(mediaType = "application/json"))
    })
    @PutMapping("/api/todo/{id}")
    public ResponseEntity updateToDo(@PathVariable("id") long id, @RequestBody ToDo toDo) {
        return todoFacade.updateToDo(id, toDo);
    }

    @Operation(summary = "Delete todo by id from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Delete todo by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/api/todo/{id}")
    public ResponseEntity<Long> deleteToDo(@PathVariable(name = "id") long id) {
        return todoFacade.deleteToDo(id);
    }
}
