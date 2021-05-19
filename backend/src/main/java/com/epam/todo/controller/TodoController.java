package com.epam.todo.controller;


import com.epam.todo.model.ToDo;
import com.epam.todo.service.TodoFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
