package com.epam.todo.service;

import com.epam.todo.model.ToDo;
import com.epam.todo.repository.ToDoJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToDoServiceTest {

  @InjectMocks
  private ToDoService underTest;

  @Mock
  private ToDoJpaRepository toDoJpaRepository;

  private List<ToDo> dto;
  private ToDo item1;

  @BeforeEach
  void setup() {
    item1 = new ToDo("1", "Read a book.", true, ZonedDateTime.parse("2020-12-08T22:27:16Z"));
    ToDo item2 = new ToDo("2", "Go shopping.", true, ZonedDateTime.parse("2020-05-27T08:05:03Z"));
    ToDo item3 = new ToDo("3", "Eat bread.", true, ZonedDateTime.parse("2020-07-15T12:32:13Z"));
    dto = Arrays.asList(item1, item2, item3);
  }

  @Test
  void testGetToDos_ShouldCalledRepositoryAndReturnTodosList_WhenCalledWithEmptyParameter() {
    //given
    List<ToDo> dto = Arrays.asList(
      new ToDo("2", "Read a book.", true, ZonedDateTime.parse("2020-12-08T22:27:16Z")),
      new ToDo("14", "Go shopping.", true, ZonedDateTime.parse("2020-05-27T08:05:03Z")),
      new ToDo("15", "Eat bread.", true, ZonedDateTime.parse("2020-07-15T12:32:13Z"))
    );
    when(toDoJpaRepository.findAll()).thenReturn(dto);
    //when
    List<ToDo> actual = underTest.getToDos();
    //then
    assertEquals(dto, actual);
    verify(toDoJpaRepository).findAll();
  }

  @Test
  void testCreateToDo_ShouldCalledRepositoryAndReturnNewTodo_WhenCalledWithValidToDo() {
    //given
    ToDo newItem = new ToDo("1", "Play piano", false, ZonedDateTime.parse("2020-07-15T12:32:13Z"));
    ToDo createdItem = new ToDo("4", "Play piano", false, ZonedDateTime.parse("2020-07-15T12:32:13Z"));

    when(toDoJpaRepository.save(newItem)).thenReturn(createdItem);
    //when
    ToDo actual = underTest.createToDo(newItem);
    //then
    assertEquals(createdItem, actual);
    verify(toDoJpaRepository).save(newItem);
  }

  @Test
  void testReadToDo_ShouldCalledRepositoryAndReturnTodo_WhenCalledWithValidId() {
    //given
    when(toDoJpaRepository.findById("1")).thenReturn(Optional.of(item1));
    //when
    ToDo actual = underTest.readToDo("1");
    //then
    assertEquals(item1, actual);
    verify(toDoJpaRepository).findById("1");
  }

  @Test
  void testReadToDo_ShouldCalledRepositoryAndThrowException_WhenCalledWithInValidId() {
    //given
    when(toDoJpaRepository.findById("1")).thenReturn(Optional.empty());
    //when
    assertThrows(NoSuchElementException.class, () -> {
      underTest.readToDo("1");
    });
  }

  @Test
  void testUpdateToDo_ShouldCalledRepositoryAndReturnUpdatedTodo_WhenCalledWithValidIdAndToDo() {
    //given
    ToDo updated = new ToDo("1", "Going to cinema.", false, ZonedDateTime.parse("2010-05-27T08:05:03Z"));
    ToDo afterUpdated = new ToDo("1", "Going to cinema.", false, ZonedDateTime.parse("2020-12-08T22:27:16Z"));
    when(toDoJpaRepository.findById("1")).thenReturn(Optional.of(item1));
    when(toDoJpaRepository.save(updated)).thenReturn(afterUpdated);
    //when
    ToDo actual = underTest.updateToDo("1", updated);
    //then
    assertEquals(afterUpdated, actual);
    verify(toDoJpaRepository).findById("1");
    verify(toDoJpaRepository).save(updated);
  }

  @Test
  void testUpdateToDo_ShouldCalledRepositoryAndSetCreationTimeStamp_WhenCalledWithInValidIds() {
    //given
    ToDo updated = new ToDo("1", "Going to cinema.", false, null);
    ToDo updatedWithTimeStamp = new ToDo("1", "Going to cinema.", false, ZonedDateTime.parse("2020-12-08T22:27:16Z"));
    when(toDoJpaRepository.findById("1")).thenReturn(Optional.of(item1));
    when(toDoJpaRepository.save(updatedWithTimeStamp)).thenReturn(updatedWithTimeStamp);
    //when
    ToDo actual = underTest.updateToDo("1", updated);
    //then
    assertEquals(updatedWithTimeStamp, actual);
    verify(toDoJpaRepository).findById("1");
    verify(toDoJpaRepository).save(updatedWithTimeStamp);
  }

  @Test
  void testUpdateToDo_ShouldCalledRepositoryAndThrowException_WhenCalledWithInValidIdAndToDo() {
    //given
    ToDo updated = new ToDo("1", "Going to cinema.", false, ZonedDateTime.parse("2010-05-27T08:05:03Z"));
    when(toDoJpaRepository.findById("1")).thenReturn(Optional.empty());
    //when
    assertThrows(NoSuchElementException.class, () -> {
      underTest.updateToDo("1", updated);
    });
  }

  @Test
  void testDeleteToDo_ShouldCalledRepositoryAndReturnVoid_WhenCalledWithValidId() {
    //given
    when(toDoJpaRepository.findById("1")).thenReturn(Optional.of(item1));
    //when
    underTest.deleteToDo("1");
    //then

    verify(toDoJpaRepository).findById("1");
    verify(toDoJpaRepository).delete(item1);
  }

  @Test
  void testDeleteToDo_ShouldCalledRepositoryAndThrowException_WhenCalledWithInValidId() {

    when(toDoJpaRepository.findById("1")).thenReturn(Optional.empty());

    assertThrows(NoSuchElementException.class, () -> {
      underTest.deleteToDo("1");
    });
  }
}
