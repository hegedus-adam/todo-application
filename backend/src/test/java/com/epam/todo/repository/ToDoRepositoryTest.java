package com.epam.todo.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToDoRepositoryTest {

    @InjectMocks
    private ToDoRepository underTest;

    @Test
    void findAll() {
    }
}