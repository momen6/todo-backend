package com.example.todobackend.rest;

import com.example.todobackend.dto.GenericResponse;
import com.example.todobackend.dto.TodoDto;
import com.example.todobackend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<GenericResponse<?>> getAllTodos(){
        return ResponseEntity.ok(this.todoService.getAllTodos());
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<GenericResponse<?>> getTodoById(@PathVariable Long id){
        return ResponseEntity.ok(this.todoService.getTodoById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<GenericResponse<?>> addTodo(@RequestBody TodoDto todoDto){
        todoDto.setTodoId(0L);
        return ResponseEntity.ok(this.todoService.saveTodo(todoDto));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<GenericResponse<?>> UpdateTodo(@RequestBody TodoDto todoDto,@PathVariable Long id){
        todoDto.setTodoId(id);
        return ResponseEntity.ok(this.todoService.saveTodo(todoDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse<?>> deleteTodo(@PathVariable Long id){
        return ResponseEntity.ok(this.todoService.deleteTodoById(id));
    }
}
