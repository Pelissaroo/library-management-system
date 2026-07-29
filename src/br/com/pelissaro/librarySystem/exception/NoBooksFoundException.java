package br.com.pelissaro.librarySystem.exception;

public class NoBooksFoundException extends RuntimeException{
    public NoBooksFoundException() {
        super("No books found");
    }

    public NoBooksFoundException(String message) {
        super(message);
    }
}
