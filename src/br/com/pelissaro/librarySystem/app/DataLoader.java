package br.com.pelissaro.librarySystem.app;

import br.com.pelissaro.librarySystem.service.BookService;
import br.com.pelissaro.librarySystem.service.UserService;

public class DataLoader {

    public DataLoader(BookService bookService, UserService userService){
        bookService.createNewBook("Clean Code", "Robert Cecil Martin");
        bookService.createNewBook("Entendendo Algoritimos", "Aditya Y. Bhargava");
        bookService.createNewBook("O programador prático", "Andrew hunt");
        bookService.createNewBook("O universo da programação", "Willian Oliveira");
        bookService.createNewBook("Algoritmos e programação", "Marco Medina");

        userService.registerUser("Caio", "12345678910", "Rua sao paulo", 10, "33933333333");
        userService.registerUser("Sofia", "01298765432", "Rua Brasil", 20, "44944444444");
        userService.registerUser("Pedro", "99988877766", "Rua Caetano", 30, "33955555555");
    }
}
