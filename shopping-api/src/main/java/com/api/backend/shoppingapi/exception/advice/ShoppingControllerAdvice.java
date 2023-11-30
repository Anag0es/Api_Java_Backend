package com.api.backend.shoppingapi.exception.advice;

import com.api.backend.shoppingapi.dto.ErrorDTO;
import com.api.backend.shoppingapi.exception.ProductNotFoundException;
import com.api.backend.shoppingapi.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "com.api.backend.controller")
public class ShoppingControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFoundException(ProductNotFoundException e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Produto não encontrado");
        errorDTO.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        errorDTO.setTimestamp(LocalDateTime.now());

        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFoundException(UserNotFoundException e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Usuário não encontrado");
        errorDTO.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        errorDTO.setTimestamp(LocalDateTime.now());

        return errorDTO;
    }

}
