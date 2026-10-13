package br.com.pelissaro.librarySystem.service;

import br.com.pelissaro.librarySystem.exception.BookNotFoundException;
import br.com.pelissaro.librarySystem.exception.InvalidStockQuantityException;
import br.com.pelissaro.librarySystem.exception.NoStockAvailableException;
import br.com.pelissaro.librarySystem.repository.BookRepository;
import br.com.pelissaro.librarySystem.domain.Book;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createNewBook(Book book){
        bookRepository.saveAndFlush(book);
    }

    public Book findBookById(Integer id){
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
    }


    public void updateBookById(Integer id, Book book){
        Book bookEntity = findBookById(id);
        Book bookUpdated = Book.builder()
                .id(bookEntity.getId())
                .title(book.getTitle() != null ? book.getTitle() : bookEntity.getTitle())
                .author(book.getAuthor() != null ? book.getAuthor() : bookEntity.getAuthor())
                .quantityAvailable(book.getQuantityAvailable() != null   ? book.getQuantityAvailable() : bookEntity.getQuantityAvailable())
                .build();
        bookRepository.saveAndFlush(bookUpdated);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void addStock(Integer id, Book.NewQuantity quantity){
        Book bookUpdate = findBookById(id);
        if (quantity.quantity() <= 0) {
            throw new InvalidStockQuantityException();
        }
        bookUpdate.setQuantityAvailable(bookUpdate.getQuantityAvailable() + quantity.quantity());
        bookRepository.saveAndFlush(bookUpdate);
    }

    public void markAsBorrowed(Integer id){
        Book book = findBookById(id);
        if (book.isAvailable()){
            book.setQuantityAvailable(book.getQuantityAvailable() - 1);
            bookRepository.saveAndFlush(book);
        } else {
            throw new NoStockAvailableException();
        }
    }

    public void deleteBook(Integer id){
        Book book = findBookById(id);
        bookRepository.delete(book);
    }
}
