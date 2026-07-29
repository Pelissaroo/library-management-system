package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.domain.Loan;

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
