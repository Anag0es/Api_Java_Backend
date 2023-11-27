package com.api.backend.Userapi.exception.advice;

import com.api.backend.shoppingapi.dto.ErrorDTO;
import com.api.backend.shoppingapi.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "com.api.backend.Userapi.controller")
public class UserControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(UserNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
}
