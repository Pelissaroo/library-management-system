package br.com.pelissaro.librarySystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NoStockAvailableException extends RuntimeException {

    public NoStockAvailableException(){
        super("No stock available");
    }

    public NoStockAvailableException(String message) {
        super(message);
    }
}
