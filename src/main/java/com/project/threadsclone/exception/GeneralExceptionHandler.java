package com.project.threadsclone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class, PostNotFoundException.class, CommentNotFoundException.class})
    public Map<String, String> handleNotFoundException(RuntimeException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Error Message", exception.getMessage());
        return errorMap;
    }
}
