package br.com.pelissaro.librarySystem.Service;


import br.com.pelissaro.librarySystem.Domain.Book;
import br.com.pelissaro.librarySystem.Domain.Loan;
import br.com.pelissaro.librarySystem.Domain.User;

import java.util.ArrayList;

public class loanService {

    ArrayList<Loan> loans = new ArrayList<>();

    public void borrow(Book book, User user){
        if (book.isAvailable() && user.isActive()) {
            Loan loan = new Loan(book, user);
            loans.add(loan);
            book.markAsBorrowed();
        }
    }

    public void listLoans(){
        for (Loan loans: loans){
            System.out.println(loans);
        }
    }

    @Override
    public String toString() {
        return "loanService{" +
                "loans=" + loans +
                '}';
    }
}
