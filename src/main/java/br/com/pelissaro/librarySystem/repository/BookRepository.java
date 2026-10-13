package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Transactional
    void deleteById(Integer id);
}

