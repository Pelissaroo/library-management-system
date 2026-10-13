package br.com.pelissaro.librarySystem.controller;

import br.com.pelissaro.librarySystem.domain.Loan;
import br.com.pelissaro.librarySystem.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @GetMapping
    public ResponseEntity<List<Loan>> findAllLoans (){
        return ResponseEntity.ok(loanService.findAllLoans());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Loan> findLoanById(@PathVariable Integer id){
        return ResponseEntity.ok(loanService.findLoanById(id));
    }

    @PostMapping()
    public ResponseEntity<Void> registerLoan(@RequestBody Loan.LoanRequest loanRequest) {
        loanService.registerLoan(loanRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/return/{id}")
    public ResponseEntity<Void> returnLoan (@PathVariable Integer id){
        loanService.returnLoan(id);
        return ResponseEntity.ok().build();
    }
}
