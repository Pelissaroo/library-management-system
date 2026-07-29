package br.com.pelissaro.librarySystem.service;


import br.com.pelissaro.librarySystem.domain.Book;
import br.com.pelissaro.librarySystem.domain.Loan;
import br.com.pelissaro.librarySystem.domain.User;
import br.com.pelissaro.librarySystem.exception.NoLoansFoundException;
import br.com.pelissaro.librarySystem.repository.loanRepository;

import java.util.List;

public class LoanService {
    loanRepository loanRepository = new loanRepository();
    private int nextLoanID;

    public void borrow(Book book, User user){
        boolean loanCreated = false;

        if (book.isAvailable() && user.isActive()) {
            Loan loan = new Loan(book, user, ++nextLoanID);
            loanRepository.addLoan(loan);
            book.markAsBorrowed();
            loanCreated = true;
        }

        if (!loanCreated){
            throw new IllegalArgumentException("Loan cannot be created");
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
}
