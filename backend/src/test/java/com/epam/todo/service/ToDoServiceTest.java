package com.epam.todo.service;

import com.epam.todo.repository.ToDoJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToDoServiceTest {

    @InjectMocks
    private ToDoService underTest;

    @Mock
    private ToDoJpaRepository toDoJpaRepository;

    @Test
    void getTodos() {
    }
}
