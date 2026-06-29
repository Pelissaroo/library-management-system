package br.com.pelissaro.librarySystem.App;

import br.com.pelissaro.librarySystem.Service.BookService;
import br.com.pelissaro.librarySystem.Service.UserService;

public class DataLoader {

    public DataLoader(BookService bookService, UserService userService){
        bookService.createNewBook("Clean Code", "Robert Cecil Martin");
        bookService.createNewBook("Entendendo Algoritimos", "Aditya Y. Bhargava");
        bookService.createNewBook("O programador prático", "Andrew hunt");
        bookService.createNewBook("O universo da programação", "Willian Oliveira");
        bookService.createNewBook("Algoritmos e programação", "Marco Medina");

        userService.registerUser("Caio", "123.456.789-10", "Rua sao paulo", 10, "(33) 9 3333-3333");
        userService.registerUser("Sofia", "012.987.654-32", "Rua Brasil", 20, "(44) 9 4444-4444");
        userService.registerUser("Pedro", "999.888.777-66", "Rua Caetano", 30, "(33) 9 5555-5555");
    }
}
