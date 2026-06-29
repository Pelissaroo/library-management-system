package br.com.pelissaro.librarySystem.Service;


import br.com.pelissaro.librarySystem.Domain.Book;
import br.com.pelissaro.librarySystem.Domain.Loan;
import br.com.pelissaro.librarySystem.Domain.User;
import br.com.pelissaro.librarySystem.Repository.loanRepository;

public class LoanService {
    loanRepository loanRepository = new loanRepository();
    private int nextLoanID;

    public void borrow(Book book, User user){
        if (book.isAvailable() && user.isActive()) {
            Loan loan = new Loan(book, user, ++nextLoanID);
            loanRepository.addLoan(loan);
            book.markAsBorrowed();
        }
    }

    public void listLoans(){
        for (Loan loans: loanRepository.findAll()){
            System.out.println(loans);
        }
    }
}
