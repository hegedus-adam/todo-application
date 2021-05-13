package com.epam.todo.controller;

import com.epam.todo.service.TodoFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TodoControllerTest {

    @InjectMocks
    private TodoController underTest;

    @Mock
    private TodoFacade todoFacade;

    @Test
    void testTodoControllerConstructor_ShouldThrowNullPointerException_WhenCalledWithNullPointer() {

        assertThrows(NullPointerException.class,
                () -> new TodoController(null));
    }

    @Test
    void getToDos() {
    }
}