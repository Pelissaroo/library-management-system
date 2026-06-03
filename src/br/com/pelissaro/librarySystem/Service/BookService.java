package br.com.pelissaro.librarySystem.Service;

import br.com.pelissaro.librarySystem.Repository.BookRepository;
import br.com.pelissaro.librarySystem.Domain.Book;

public class BookService{
    BookRepository bookRepository = new BookRepository();

    public void createNewBook(String title, String author){
        Book book = new Book(title, author);
        bookRepository.addBooks(book);
    }

    public void showBooks (){
        for (Book books: bookRepository.findAll()){
            System.out.println(books);
        }
    }

}
