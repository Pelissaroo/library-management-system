package br.com.pelissaro.librarySystem.Service;

import br.com.pelissaro.librarySystem.Repository.bookRepository;
import br.com.pelissaro.librarySystem.Domain.Book;

public class BookService {
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

    public void updateTitle(Book book, String title){
        book.setTitle(title);
    }

    public void updateAuthor(Book book, String author){
        book.setAuthor(author);
    }



}
