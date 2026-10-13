package br.com.pelissaro.librarySystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class LoanCreateException extends RuntimeException {

    public LoanCreateException(){
        super("Loan cannot be created");
    }

    public LoanCreateException(String message) {
        super(message);
    }
}
