package br.com.pelissaro.librarySystem.Repository;

import br.com.pelissaro.librarySystem.Domain.Book;

import java.util.ArrayList;
import java.util.List;

public class bookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBooks(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(int id){
        for (Book book: books) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }
}

