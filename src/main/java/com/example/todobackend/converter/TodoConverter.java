package com.example.todobackend.converter;

import com.example.todobackend.dto.TodoDto;
import com.example.todobackend.model.Todo;

public class TodoConverter {

    public static TodoDto toDto(Todo todo){
        return TodoDto.builder()
                .todoId(todo.getTodoId())
                .task(todo.getTask())
                .date(todo.getDate())
                .isDone(todo.isDone())
                .build();
    }

    public static Todo toEntity(TodoDto dto){
        return Todo.builder()
                .todoId(dto.getTodoId())
                .task(dto.getTask())
                .date(dto.getDate())
                .isDone(dto.isDone())
                .build();
    }
}
