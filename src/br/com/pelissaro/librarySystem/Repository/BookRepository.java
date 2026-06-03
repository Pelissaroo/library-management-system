package br.com.pelissaro.librarySystem.Repository;

import br.com.pelissaro.librarySystem.Domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBooks(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }

}

