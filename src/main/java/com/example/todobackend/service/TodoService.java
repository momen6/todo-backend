package com.example.todobackend.service;

import com.example.todobackend.dto.GenericResponse;
import com.example.todobackend.dto.TodoDto;
import com.example.todobackend.exception.ResourceNotFoundException;
import com.example.todobackend.model.Todo;
import com.example.todobackend.repository.TodoRepository;
import com.example.todobackend.util.ModelMapperUtil;
import com.example.todobackend.util.enums.ErrorMessage;
import com.example.todobackend.util.enums.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public GenericResponse<?> getAllTodos(){
        try {
            return GenericResponse.builder()
                    .data(this.todoRepository.findAll().stream().map(todo -> ModelMapperUtil.MAPPER().map(todo, TodoDto.class)))
                    .responseMessage(ResponseMessage.SUCCESS)
                    .responseCode(ResponseMessage.SUCCESS.getCode())
                    .build();
        }catch (ResourceNotFoundException exception){
            return GenericResponse.builder()
                    .responseMessage(ResponseMessage.FAIL)
                    .responseCode(ResponseMessage.FAIL.getCode())
                    .errorMessage(ErrorMessage.INTERNAL_SERVER_ERROR.getMessage())
                    .build();
        }
    }

    public GenericResponse<?> getTodoById(Long id){
        try {
            Todo todo = this.todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Todos Found with this Id:" + id));
            return GenericResponse.builder()
                    .data(todo)
                    .responseMessage(ResponseMessage.SUCCESS)
                    .responseCode(ResponseMessage.SUCCESS.getCode())
                    .build();
        }catch (ResourceNotFoundException exception){
            return GenericResponse.builder()
                    .responseMessage(ResponseMessage.FAIL)
                    .responseCode(ResponseMessage.FAIL.getCode())
                    .errorMessage(ErrorMessage.INVALID_CREDENTIALS.getMessage())
                    .build();
        }
    }

    public GenericResponse<?> saveTodo(TodoDto todoDto){

        try {
            Todo todo = this.todoRepository.save(ModelMapperUtil.MAPPER().map(todoDto, Todo.class));
            return GenericResponse.builder()
                    .data(todo)
                    .responseMessage(ResponseMessage.SUCCESS)
                    .responseCode(ResponseMessage.SUCCESS.getCode())
                    .build();
        }catch (ResourceNotFoundException exception){
            return GenericResponse.builder()
                    .responseMessage(ResponseMessage.FAIL)
                    .responseCode(ResponseMessage.FAIL.getCode())
                    .errorMessage(ErrorMessage.INVALID_CREDENTIALS.getMessage())
                    .build();
        }

    }

    public GenericResponse<?> deleteTodoById(Long id){
        try {
            Optional<Todo> todo = this.todoRepository.findById(id);
            if (todo.isPresent())
                this.todoRepository.deleteById(id);
            else throw new ResourceNotFoundException("No ToDos Found with this Id: " + id);
            return GenericResponse.builder()
                    .data("Todo Removed!!")
                    .responseMessage(ResponseMessage.SUCCESS)
                    .responseCode(ResponseMessage.SUCCESS.getCode())
                    .build();
        }catch (ResourceNotFoundException exception){
            return GenericResponse.builder()
                    .responseMessage(ResponseMessage.FAIL)
                    .responseCode(ResponseMessage.FAIL.getCode())
                    .errorMessage(ErrorMessage.INVALID_CREDENTIALS.getMessage())
                    .build();
        }
    }
}
