package br.com.pelissaro.librarySystem.exception;

public class NoLoansFoundException extends RuntimeException {
    public NoLoansFoundException(){
        super("No Loans found");
    }
    public NoLoansFoundException(String message) {
        super(message);
    }
}
