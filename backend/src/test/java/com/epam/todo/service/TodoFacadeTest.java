package com.epam.todo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TodoFacadeTest {

    @InjectMocks
    private TodoFacade underTest;

    @Mock
    private ToDoService toDoService;

    @Test
    void testTodoFacadeConstructor_ShouldThrowNullPointerException_WhenCalledWithNullPointer() {

        assertThrows(NullPointerException.class,
                () -> new TodoFacade(null));
    }

    @Test
    void getTodos() {
    }
}