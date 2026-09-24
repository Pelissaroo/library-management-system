package br.com.pelissaro.librarySystem.exception;

public class LoanAlreadyReturnedException extends RuntimeException {
    public LoanAlreadyReturnedException (){
        super("Loan Already Returned");
    }
    public LoanAlreadyReturnedException(String message) {
        super(message);
    }
}
