package com.epam.todo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TodoFacadeTest {

    @InjectMocks
    private TodoFacade underTest;

    @Mock
    private ToDoService toDoService;

    @Test
    void getTodos() {
    }
}