package br.com.pelissaro.librarySystem.controller;

import br.com.pelissaro.librarySystem.domain.Book;
import br.com.pelissaro.librarySystem.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    @PostMapping
    public ResponseEntity<Void> registerBook(@Valid @RequestBody Book book) {
        bookService.createNewBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Integer id){
        return ResponseEntity.ok(bookService.findBookById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@Valid @PathVariable Integer id, @RequestBody Book book){
        bookService.updateBookById(id, book);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/addStock/{id}")
    public ResponseEntity<Void> addStock(@PathVariable Integer id, @RequestBody Book.NewQuantity quantity){
        bookService.addStock(id, quantity);
        return ResponseEntity.ok().build();
    }
}
