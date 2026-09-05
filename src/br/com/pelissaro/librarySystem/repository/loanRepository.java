package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.conn.ConnectionFactory;
import br.com.pelissaro.librarySystem.domain.Loan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class loanRepository {
    ArrayList<Loan> loans = new ArrayList<>();

    public void addLoan(Loan loan){
        String sql = "INSERT INTO library_system.loan (book_id, user_id) VALUES (?,?);";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, loan.getBook().getId());
            stmt.setInt(2, loan.getUser().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Loan> findAll() {
        return loans;
    }

}
