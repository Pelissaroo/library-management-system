package br.com.pelissaro.librarySystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidStockQuantityException extends RuntimeException {

    public InvalidStockQuantityException(){
        super("Invalid stock quantity entered");
    }

    public InvalidStockQuantityException(String message) {
        super(message);
    }
}
