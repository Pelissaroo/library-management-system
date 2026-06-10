package br.com.pelissaro.librarySystem.Repository;

import br.com.pelissaro.librarySystem.Domain.Loan;

import java.util.ArrayList;
import java.util.List;

public class loanRepository {
    ArrayList<Loan> loans = new ArrayList<>();

    public void addLoan(Loan loan){
        loans.add(loan);
    }

    public List<Loan> findAll() {
        return loans;
    }

}
