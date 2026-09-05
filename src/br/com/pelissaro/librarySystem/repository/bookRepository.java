package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.conn.ConnectionFactory;
import br.com.pelissaro.librarySystem.domain.Book;

import java.sql.*;
import java.util.ArrayList;

public class bookRepository {

    public void addBooks(Book book) {
        String sql = "INSERT INTO library_system.book (title,author) VALUES (?,?);";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Book findById(int id){
        String sql = "SELECT * FROM library_system.book WHERE id = ?";

        Book book = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                    book = new Book(rs.getString("title"),rs.getString("author"));
                    book.setId(rs.getInt("id"));
                }
            }
                catch (SQLException e) {
                System.out.println(e.getMessage());
                }
        return book;
    }

    public ArrayList<Book> findAll() {
        String sql = "SELECT * FROM library_system.book";

        ArrayList <Book> books = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Book book = new Book(rs.getString("title"), rs.getString("author"));
                book.setId(rs.getInt("id"));
                books.add(book);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    public void updateTitle(Book book, String title){
        String sql = "UPDATE library_system.book SET title = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, title);
            stmt.setInt(2, book.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAuthor(Book book, String author){
        String sql = "UPDATE library_system.book SET author = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, author);
            stmt.setInt(2, book.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(Book book){
        String sql = "DELETE FROM library_system.book WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, book.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

