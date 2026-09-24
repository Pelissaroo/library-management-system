package br.com.pelissaro.librarySystem.exception;

public class DuplicateEntryException extends RuntimeException {

  public DuplicateEntryException(){
    super("Duplicate entry exception");
  }
    public DuplicateEntryException(String message) {
        super(message);
    }
}
