package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.conn.ConnectionFactory;
import br.com.pelissaro.librarySystem.domain.Book;
import br.com.pelissaro.librarySystem.domain.Loan;
import br.com.pelissaro.librarySystem.domain.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class loanRepository {
    bookRepository bookRepository = new bookRepository();

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

    public List<Loan> findAll(){
        String sql =  "SELECT loan.loan_id, loan.book_id AS book_real_id, loan.user_id AS user_real_id, book.title, book.author, book.quantity_available, user.name, user.cpf, user.address, user.address_number, user.phone_number, user.active FROM library_system.loan INNER JOIN library_system.book ON loan.book_id = book.id INNER JOIN library_system.user ON loan.user_id = user.id";

        ArrayList <Loan> loans = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Book book = new Book(rs.getString("title"), rs.getString("author"), rs.getInt("quantity_available"));
                book.setId(rs.getInt("book_real_id"));
                User user = new User(rs.getString("name"), rs.getString("cpf"), rs.getString("address"), rs.getInt("address_number"), rs.getString("phone_number"));
                user.setId(rs.getInt("user_real_id"));

                Loan loan = new Loan(book,user);
                loan.setLoanID(rs.getInt("loan_id"));
                loans.add(loan);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return loans;
    }

    public Loan findLoanById(int id){
        String sql =  "SELECT loan.loan_id, loan.book_id AS book_real_id, loan.user_id AS user_real_id, loan.created_at, loan.returned_at, book.title, book.author, book.quantity_available, user.name, user.cpf, user.address, user.address_number, user.phone_number, user.active FROM library_system.loan INNER JOIN library_system.book ON loan.book_id = book.id INNER JOIN library_system.user ON loan.user_id = user.id WHERE loan_id = ?";

        Loan loanResult = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Book book = new Book(rs.getString("title"), rs.getString("author"), rs.getInt("quantity_available"));
                book.setId(rs.getInt("book_real_id"));
                User user = new User(rs.getString("name"), rs.getString("cpf"), rs.getString("address"), rs.getInt("address_number"), rs.getString("phone_number"));
                user.setId(rs.getInt("user_real_id"));

                Loan loan = new Loan(book,user);
                loan.setLoanID(rs.getInt("loan_id"));
                loan.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                Timestamp returnedAtRaw = rs.getTimestamp("returned_at");
                loan.setReturned_at(returnedAtRaw != null ? returnedAtRaw.toLocalDateTime() : null);

                loanResult = loan;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return loanResult;
    }

    public void returnLoan(Loan loan){
        String sql = "UPDATE library_system.loan SET returned_at = CURRENT_TIMESTAMP WHERE loan_id = ?;";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, loan.getLoanID());
            bookRepository.markAsReturned(loan.getBook());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
