package com.epam.todo.controller;

import com.epam.todo.model.ToDo;
import com.epam.todo.model.UpdateToDo;
import com.epam.todo.service.TodoFacade;
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
class TodoControllerTest {

  @InjectMocks
  private TodoController underTest;

  @Mock
  private TodoFacade todoFacade;

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
  void testGetToDos_ShouldCalledFacadeAndReturnTodosList_WhenCalledWithEmptyParameter() {
    //given
    when(todoFacade.getToDos()).thenReturn(new ResponseEntity<>(dto, HttpStatus.OK));
    //when
    ResponseEntity<List<ToDo>> actual = underTest.getToDos();
    //then
    ResponseEntity<List<ToDo>> expected = new ResponseEntity<>(dto, HttpStatus.OK);

    assertEquals(expected, actual);
    verify(todoFacade).getToDos();
  }

  @Test
  void testCreateToDo_ShouldCalledFacadeAndReturnNewTodo_WhenCalledWithValidToDo() {
    //given
    ToDo newItem = new ToDo(1, "Play piano", false, ZonedDateTime.parse("2020-07-15T12:32:13Z"));
    ToDo createdItem = new ToDo(4, "Play piano", false, ZonedDateTime.parse("2020-07-15T12:32:13Z"));

    when(todoFacade.createToDo(newItem)).thenReturn(new ResponseEntity<>(createdItem, HttpStatus.CREATED));
    //when
    ResponseEntity<ToDo> actual = underTest.createToDo(newItem);
    //then
    ResponseEntity<ToDo> expected = new ResponseEntity<>(createdItem, HttpStatus.CREATED);

    assertEquals(expected, actual);
    verify(todoFacade).createToDo(newItem);
  }

  @Test
  void testReadToDo_ShouldCalledFacadeAndReturnTodo_WhenCalledWithValidId() {
    //given
    when(todoFacade.readToDo(1L)).thenReturn(new ResponseEntity<>(item1, HttpStatus.OK));
    //when
    ResponseEntity<ToDo> actual = underTest.readToDo(1L);
    //then
    ResponseEntity<ToDo> expected = new ResponseEntity<>(item1, HttpStatus.OK);

    assertEquals(expected, actual);
    verify(todoFacade).readToDo(1L);
  }

  @Test
  void testUpdateToDo_ShouldCalledFacadeAndReturnUpdatedTodo_WhenCalledWithValidIdAndToDo() {
    //given
    UpdateToDo updated = new UpdateToDo("Going to cinema.", false);
    ToDo toDo = new ToDo(1, "Going to cinema.", false, null);

    when(todoFacade.updateToDo(1L, toDo)).thenReturn(new ResponseEntity<>(toDo, HttpStatus.OK));
    //when
    ResponseEntity<ToDo> actual = underTest.updateToDo(1L, updated);
    //then
    ResponseEntity<ToDo> expected = new ResponseEntity<>(toDo, HttpStatus.OK);

    assertEquals(expected, actual);
    verify(todoFacade).updateToDo(1L, toDo);
  }

  @Test
  void testDeleteToDo_ShouldCalledFacadeAndReturnId_WhenCalledWithValidId() {
    //given
    when(todoFacade.deleteToDo(1L)).thenReturn(new ResponseEntity<>(1L, HttpStatus.OK));
    //when
    ResponseEntity<Long> actual = underTest.deleteToDo(1L);
    //then
    ResponseEntity<Long> expected = new ResponseEntity<>(1L, HttpStatus.OK);

    assertEquals(expected, actual);
    verify(todoFacade).deleteToDo(1L);
  }
}
