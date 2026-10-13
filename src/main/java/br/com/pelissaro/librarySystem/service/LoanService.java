package br.com.pelissaro.librarySystem.service;


import br.com.pelissaro.librarySystem.domain.Book;
import br.com.pelissaro.librarySystem.domain.Loan;
import br.com.pelissaro.librarySystem.domain.User;
import br.com.pelissaro.librarySystem.exception.*;
import br.com.pelissaro.librarySystem.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookService bookService;
    private final UserService userService;

    public LoanService(LoanRepository loanRepository, BookService bookService, UserService userService) {
        this.loanRepository = loanRepository;
        this.bookService = bookService;
        this.userService = userService;
    }

    @Transactional
    public void registerLoan(Loan.LoanRequest loanRequest){
        Book book = bookService.findBookById(loanRequest.bookId());
        User user = userService.findUserById(loanRequest.userId());

        if (book.isAvailable() && user.isActive()) {
            Loan loan = new Loan(book, user);
            loanRepository.saveAndFlush(loan);
            bookService.markAsBorrowed(book.getId());
        } else {
            throw new LoanCreateException();
        }
    }

    public List<Loan> findAllLoans(){
        return loanRepository.findAll();
    }

    public Loan findLoanById(Integer id){
        if (id < 1){
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        return loanRepository.findById(id).orElseThrow(LoanNotFoundException::new);
    }

    @Transactional
    public void returnLoan(Integer id){
            Loan loanEntity = findLoanById(id);

            if (loanEntity.getReturnedAt() == null){
                loanEntity.getBook().setQuantityAvailable(loanEntity.getBook().getQuantityAvailable() + 1);
                loanEntity.setReturnedAt(LocalDateTime.now());
                loanRepository.saveAndFlush(loanEntity);
            } else {
            throw new LoanAlreadyReturnedException();
        }
    }
}
