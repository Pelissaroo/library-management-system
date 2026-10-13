package br.com.pelissaro.librarySystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class LoanAlreadyReturnedException extends RuntimeException {
    public LoanAlreadyReturnedException (){
        super("Loan Already Returned");
    }
    public LoanAlreadyReturnedException(String message) {
        super(message);
    }
}
