package com.epam.todo.service;

import com.epam.todo.model.ToDo;
import org.junit.jupiter.api.BeforeEach;
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
class TodoFacadeTest {

    @InjectMocks
    private TodoFacade underTest;

    @Mock
    private ToDoService toDoService;

    private List<ToDo> dto;
    private ToDo item1;

    @BeforeEach
    void setup() {
        item1 = new ToDo(1, "Read a book.", true, ZonedDateTime.parse("2020-12-08T22:27:16Z"));
        ToDo item2 = new ToDo(2, "Go shopping.", true, ZonedDateTime.parse("2020-05-27T08:05:03Z"));
        ToDo item3 = new ToDo(3, "Eat bread.", true, ZonedDateTime.parse("2020-07-15T12:32:13Z"));
        dto = Arrays.asList(item1, item2, item3);
    }

    @Test
    void testGetToDos_ShouldCalledServiceAndReturnTodosList_WhenCalledWithEmptyParameter() {
        //given
        when(toDoService.getToDos()).thenReturn(dto);
        //when
        ResponseEntity<List<ToDo>> actual = underTest.getToDos();
        //then
        ResponseEntity<List<ToDo>> expected = new ResponseEntity<>(dto, HttpStatus.OK);

        assertEquals(expected, actual);
        verify(toDoService).getToDos();
    }

    @Test
    void testCreateToDo_ShouldCalledServiceAndReturnNewTodo_WhenCalledWithValidToDo() {
        //given
        ToDo newItem =
                new ToDo(1, "Play piano", false, ZonedDateTime.parse("2020-07-15T12:32:13Z"));
        ToDo createdItem = new ToDo(4, "Play piano", false, ZonedDateTime.parse("2020-07-15T12:32:13Z"));

        when(toDoService.createToDo(newItem)).thenReturn(createdItem);
        //when
        ResponseEntity<ToDo> actual = underTest.createToDo(newItem);
        //then
        ResponseEntity<ToDo> expected = new ResponseEntity<>(createdItem, HttpStatus.CREATED);

        assertEquals(expected, actual);
        verify(toDoService).createToDo(newItem);
    }

    @Test
    void testReadToDo_ShouldCalledServiceAndReturnTodo_WhenCalledWithValidId() {
        //given
        when(toDoService.readToDo(1L)).thenReturn(item1);
        //when
        ResponseEntity<ToDo> actual = underTest.readToDo(1L);
        //then
        ResponseEntity<ToDo> expected = new ResponseEntity<>(item1, HttpStatus.OK);

        assertEquals(expected, actual);
        verify(toDoService).readToDo(1L);
    }

    @Test
    void testUpdateToDo_ShouldCalledServiceAndReturnUpdatedTodo_WhenCalledWithValidIdAndToDo() {
        //given
        ToDo updated = new ToDo(1, "Going to cinema.", false, ZonedDateTime.parse("2010-05-27T08:05:03Z"));
        ToDo afterUpdated = new ToDo(1, "Going to cinema.", false, ZonedDateTime.parse("2020-12-08T22:27:16Z"));
        when(toDoService.updateToDo(1L, updated)).thenReturn(afterUpdated);
        //when
        ResponseEntity<ToDo> actual = underTest.updateToDo(1L, updated);
        //then
        ResponseEntity<ToDo> expected = new ResponseEntity<>(afterUpdated, HttpStatus.OK);

        assertEquals(expected, actual);
        verify(toDoService).updateToDo(1L, updated);
    }

    @Test
    void testDeleteToDo_ShouldCalledServiceAndReturnId_WhenCalledWithValidId() {
        //when
        ResponseEntity<Long> actual = underTest.deleteToDo(1L);
        //then
        ResponseEntity<Long> expected = new ResponseEntity<>(1L, HttpStatus.OK);

        assertEquals(expected, actual);
        verify(toDoService).deleteToDo(1L);
    }
}
