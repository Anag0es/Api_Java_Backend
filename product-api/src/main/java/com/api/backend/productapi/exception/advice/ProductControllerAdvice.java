package com.api.backend.productapi.exception.advice;

import com.api.backend.shoppingapi.dto.ErrorDTO;
import com.api.backend.shoppingapi.exception.CategoryNotFoundException;
import com.api.backend.shoppingapi.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.Binding;
import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice(basePackages = "com.api.backend.productapi.controller")
public class ProductControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFound(ProductNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorDTO handleCategoryNotFound(CategoryNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErros = bindingResult.getFieldErrors();
        StringBuilder sb =
                new StringBuilder("Valor inválido para o(s) campo(s): ");

        for (FieldError fieldError : fieldErros) {
            sb.append(fieldError.getField());
            sb.append(", ");
        }
        errorDTO.setMessage(sb.toString());
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
}
