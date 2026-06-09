package br.com.pelissaro.librarySystem.Service;

import br.com.pelissaro.librarySystem.Repository.bookRepository;
import br.com.pelissaro.librarySystem.Domain.Book;

public class bookService {
    bookRepository bookRepository = new bookRepository();

    public void createNewBook(String title, String author){
        Book book = new Book(title, author);
        bookRepository.addBooks(book);
    }

    public void showBooks (){
        for (Book books: bookRepository.findAll()){
            System.out.println(books);
        }
    }

    public Book findBookByID(int id){
        return bookRepository.findById(id);
    }

}
