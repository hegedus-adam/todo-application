package com.epam.todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UpdateToDo {

  @JsonProperty("title")
  String title;

  @JsonProperty("isDone")
  private Boolean isDone;

  public UpdateToDo() {
  }

  public UpdateToDo(String title, Boolean isDone) {
    this.title = title;
    this.isDone = isDone;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean getDone() {
    return isDone;
  }

  public void setDone(Boolean done) {
    isDone = done;
  }

  public ToDo createToDo(long id) {
    return new ToDo(id, title, isDone);
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    UpdateToDo that = (UpdateToDo) o;
    return Objects.equals(title, that.title) && Objects.equals(isDone, that.isDone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, isDone);
  }

  @Override
  public String toString() {
    return "UpdateToDo{" + "title='" + title + '\'' + ", isDone=" + isDone + '}';
  }
}
