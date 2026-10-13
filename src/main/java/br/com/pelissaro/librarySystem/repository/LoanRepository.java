package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface LoanRepository extends JpaRepository<Loan, Integer> {

    @Transactional
    void deleteById(Integer id);

}
