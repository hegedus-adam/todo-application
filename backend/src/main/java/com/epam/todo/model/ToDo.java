package com.epam.todo.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "todos")
public class ToDo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  String id;

  @Column(name = "title")
  String title;

  @Column(name = "is_done")
  private Boolean isDone;

  @Column(name = "creation_timestamp", updatable = false)
  @CreationTimestamp
  private ZonedDateTime creationTimestamp;

  public ToDo() {
  }

  public ToDo(String id, String title, Boolean isDone, ZonedDateTime creationTimestamp) {
    this.id = id;
    this.title = title;
    this.isDone = isDone;
    this.creationTimestamp = creationTimestamp;
  }

  public ToDo(String id, String title, Boolean isDone) {
    this.id = id;
    this.title = title;
    this.isDone = isDone;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
    com.epam.todo.model.ToDo toDo = (com.epam.todo.model.ToDo) o;
    return id.equals(toDo.id) && title.equals(toDo.title) && isDone.equals(toDo.isDone) && creationTimestamp.equals(toDo.creationTimestamp);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, title, isDone, creationTimestamp);
  }
}
