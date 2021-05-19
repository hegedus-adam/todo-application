package com.epam.todo.controller;

import com.epam.todo.model.ToDo;
import com.epam.todo.service.TodoFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoControllerTest {

    @InjectMocks
    private TodoController underTest;

    @Mock
    private TodoFacade todoFacade;

    @Test
    void testGetToDos_ShouldCalledFacadeAndReturnTodosList_WhenCalledWithEmptyParameter() {
        //given
        List<ToDo> dto = Arrays.asList(
                new ToDo(2, "Read a book.", true, ZonedDateTime.parse("2020-12-08T22:27:16Z")),
                new ToDo(14, "Go shopping.", true, ZonedDateTime.parse("2020-05-27T08:05:03Z")),
                new ToDo(15, "Eat bread.", true, ZonedDateTime.parse("2020-07-15T12:32:13Z"))
        );
        when(todoFacade.getToDos()).thenReturn(new ResponseEntity<List<ToDo>>(dto, HttpStatus.OK));
        //when
        ResponseEntity<List<ToDo>> actual = underTest.getToDos();
        //then
        ResponseEntity<List<ToDo>> expected = new ResponseEntity<>(dto, HttpStatus.OK);

        assertEquals(expected, actual);
        verify(todoFacade).getToDos();
    }
}
