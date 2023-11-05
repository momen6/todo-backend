package com.example.todobackend.dto;

import com.example.todobackend.util.enums.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {

    private T data;
    private ResponseMessage responseMessage;
    private Long responseCode;
    private String errorMessage;
}
