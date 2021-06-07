package com.epam.todo.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "todos")
public class ToDo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @Column(name = "title")
  String title;

  @Column(name = "is_done")
  private Boolean isDone;

  @Column(name = "creation_timestamp", updatable = false)
  @CreationTimestamp
  private ZonedDateTime creationTimestamp;

  public ToDo() {
  }

  public ToDo(long id, String title, Boolean isDone, ZonedDateTime creationTimestamp) {
    this.id = id;
    this.title = title;
    this.isDone = isDone;
    this.creationTimestamp = creationTimestamp;
  }

  public ToDo(long id, String title, Boolean isDone) {
    this.id = id;
    this.title = title;
    this.isDone = isDone;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean getIsDone() {
    return isDone;
  }

  public void setIsDone(Boolean done) {
    isDone = done;
  }

  public ZonedDateTime getCreationTimestamp() {
    return creationTimestamp;
  }

  public void setCreationTimestamp(ZonedDateTime creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToDo toDo = (ToDo) o;
    return id == toDo.id && Objects.equals(title, toDo.title) && Objects.equals(isDone, toDo.isDone) && Objects.equals(creationTimestamp,
                                                                                                                       toDo.creationTimestamp
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, isDone, creationTimestamp);
  }

  @Override
  public String toString() {
    return "ToDo{" + "id=" + id + ", title='" + title + '\'' + ", isDone=" + isDone + ", creationTimestamp=" + creationTimestamp + '}';
  }
}
