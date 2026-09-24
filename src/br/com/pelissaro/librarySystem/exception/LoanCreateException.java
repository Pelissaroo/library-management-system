package br.com.pelissaro.librarySystem.exception;

public class LoanCreateException extends RuntimeException {

    public LoanCreateException(){
        super("Loan cannot be created");
    }

    public LoanCreateException(String message) {
        super(message);
    }
}
