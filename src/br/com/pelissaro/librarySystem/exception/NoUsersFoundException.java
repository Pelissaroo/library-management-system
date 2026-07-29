package br.com.pelissaro.librarySystem.exception;

public class NoUsersFoundException extends RuntimeException {

    public NoUsersFoundException (){
        super ("No users found");
    }

    public NoUsersFoundException(String message) {
        super(message);
    }
}
