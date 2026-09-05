package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.conn.ConnectionFactory;
import br.com.pelissaro.librarySystem.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public List<User> findAll() {
        return users;
    }

    public User findById(int id){
        for (User user: users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
