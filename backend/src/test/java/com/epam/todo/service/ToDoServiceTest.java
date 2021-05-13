package com.epam.todo.service;

import com.epam.todo.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ToDoServiceTest {

    @InjectMocks
    private ToDoService underTest;

    @Mock
    private ToDoRepository toDoRepository;

    @Test
    void testToDoServiceConstructor_ShouldThrowNullPointerException_WhenCalledWithNullPointer() {

        assertThrows(NullPointerException.class,
                () -> new ToDoService(null));
    }

    @Test
    void getTodos() {
    }
}