package com.project.gestionPedidos.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductoAlreadyExistsException extends RuntimeException{
    private String message;
    public ProductoAlreadyExistsException(String message){
        super(message);
    }
}
