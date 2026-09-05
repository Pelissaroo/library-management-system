package br.com.pelissaro.librarySystem.service;

import br.com.pelissaro.librarySystem.exception.BookNotFoundException;
import br.com.pelissaro.librarySystem.exception.NoBooksFoundException;
import br.com.pelissaro.librarySystem.repository.bookRepository;
import br.com.pelissaro.librarySystem.domain.Book;

import java.util.List;

public class BookService {
    bookRepository bookRepository = new bookRepository();

    public void createNewBook(String title, String author){
        if (title.isBlank()){
            throw new IllegalArgumentException("Book title cannot be empty");
        }

        if (author.isBlank()){
            throw new IllegalArgumentException("Author name cannot be empty");
        }

        Book book = new Book(title, author);
        bookRepository.addBooks(book);
    }

    public void showBooks (){
        List<Book> findBooks = bookRepository.findAll();
        if (findBooks.isEmpty()){
            throw new NoBooksFoundException();
        }
        for (Book books: findBooks){
            System.out.println(books);
        }
    }

    public Book findBookByID(int id){
        if (id < 1){
            throw new IllegalArgumentException("ID cannot be less than 0");
        }
        Book book = bookRepository.findById(id);
        if (book == null){
            throw new BookNotFoundException();
        }
        return book;
    }

    public void validateInputString (String string){
        if (!string.matches("^[\\p{L}\\s]+$")){
            throw new IllegalArgumentException();
        }
    }

    public void updateTitle(Book book, String title){
        bookRepository.updateTitle(book, title);
    }

    public void updateAuthor(Book book, String author){
        bookRepository.updateAuthor(book, author);
    }

    public void deleteBook(Book book){
        bookRepository.deleteBook(book);
    }


}
