package com.epam.todo.controller;


import com.epam.todo.model.ToDo;
import com.epam.todo.service.TodoFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class TodoController {

    private final TodoFacade todoFacade;

    public TodoController(TodoFacade todoFacade) {
        Objects.requireNonNull(todoFacade);
        this.todoFacade = todoFacade;
    }

    @Operation(summary = "Download required namedays by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Given back username and reminded namedays",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/api/todo")
    public List<ToDo> getToDos() {
        return todoFacade.getTodos();
    }
}
