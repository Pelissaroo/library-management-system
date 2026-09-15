package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.conn.ConnectionFactory;
import br.com.pelissaro.librarySystem.domain.Book;
import br.com.pelissaro.librarySystem.domain.User;
import br.com.pelissaro.librarySystem.exception.DuplicateEntryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userRepository {
    private ArrayList<User> users = new ArrayList<>();

    public void addUsers(User user) {
        String sql = "INSERT INTO library_system.user (name, cpf, address, address_number, phone_number) VALUES (?,?,?,?,?);";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,user.getName());
            stmt.setString(2,user.getCpf());
            stmt.setString(3,user.getAddress());
            stmt.setInt(4,user.getAddressNumber());
            stmt.setString(5,user.getPhoneNumber());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<User> findAll() {
        String sql = "SELECT * FROM library_system.user";

        ArrayList <User> users = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                User user = new User(rs.getString("name"), rs.getString("cpf"), rs.getString("address"), rs.getInt("address_number"), rs.getString("phone_number"));
                user.setId(rs.getInt("id"));
                user.setActive(rs.getBoolean("active"));
                users.add(user);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public User findById(int id){
        String sql = "SELECT * FROM library_system.user WHERE id = ?";

        User user = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                user = new User(rs.getString("name"), rs.getString("cpf"), rs.getString("address"), rs.getInt("address_number"), rs.getString("phone_number"));
                user.setId(rs.getInt("id"));
                user.setActive(rs.getBoolean("active"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public void updateName(User user, String name){
        String sql = "UPDATE library_system.user SET name = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, name);
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCPF(User user, String cpf){
        String sql = "UPDATE library_system.user SET cpf = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, cpf);
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            if (e.getMessage().contains("cpf")) {
                throw new DuplicateEntryException("Already exists a user with this cpf registered");
            }
            throw new RuntimeException("Error on connect DataBase", e);
        }
    }

    public void updateAddress(User user, String address){
        String sql = "UPDATE library_system.user SET address = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, address);
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAddressNumber(User user, int addressNumber){
        String sql = "UPDATE library_system.user SET address_number = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, addressNumber);
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePhoneNumber(User user, String phoneNumber){
        String sql = "UPDATE library_system.user SET phone_number = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, phoneNumber);
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            if (e.getMessage().contains("phone_number")) {
                throw new DuplicateEntryException("Already exists a user with this phone number registered");
            }
            throw new RuntimeException("Error on connect DataBase", e);
        }
    }

    public void deleteUser(User user){
        String sql = "DELETE FROM library_system.user WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
