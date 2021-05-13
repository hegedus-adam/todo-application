package com.epam.todo.model;

import java.util.List;
import java.util.Objects;

public class ToDosDto {

    private final List<ToDo> toDos;

    public ToDosDto(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDosDto toDosDto = (ToDosDto) o;
        return Objects.equals(toDos, toDosDto.toDos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toDos);
    }

    @Override
    public String toString() {
        return "ToDosDto{" +
                "toDos=" + toDos +
                '}';
    }
}
