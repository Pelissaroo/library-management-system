package br.com.pelissaro.librarySystem.service;


import br.com.pelissaro.librarySystem.domain.Book;
import br.com.pelissaro.librarySystem.domain.Loan;
import br.com.pelissaro.librarySystem.domain.User;
import br.com.pelissaro.librarySystem.exception.LoanAlreadyReturnedException;
import br.com.pelissaro.librarySystem.exception.LoanCreateException;
import br.com.pelissaro.librarySystem.exception.LoanNotFoundException;
import br.com.pelissaro.librarySystem.exception.NoLoansFoundException;
import br.com.pelissaro.librarySystem.repository.loanRepository;

import java.util.List;

public class LoanService {
    loanRepository loanRepository = new loanRepository();
    BookService bookService = new BookService();

    public void borrow(Book book, User user){
        boolean loanCreated = false;

        if (book.isAvailable() && user.isActive()) {
            Loan loan = new Loan(book, user);
            loanRepository.addLoan(loan);
            bookService.markAsBorrowed(book);
            loanCreated = true;
        }

        if (!loanCreated){
            throw new LoanCreateException();
        }

    }

    public void listLoans(){
        List<Loan> findLoans = loanRepository.findAll();
        if (findLoans.isEmpty()){
            throw new NoLoansFoundException();
        }
        for (Loan loans : findLoans){
            System.out.println(loans);
        }
    }

    public Loan findLoanById(int id){
        if (id < 1){
            throw new IllegalArgumentException("ID cannot be less than 0");
        }
        Loan loan = loanRepository.findLoanById(id);
        if (loan == null){
            throw new LoanNotFoundException();
        }
        return loan;
    }

    public void returnLoan(Loan loan){
        if (loan.getReturned_at() == null){
            loanRepository.returnLoan(loan);
        } else {
            throw new LoanAlreadyReturnedException();
        }
    }
}
