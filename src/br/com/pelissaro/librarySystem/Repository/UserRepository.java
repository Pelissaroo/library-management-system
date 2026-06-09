package br.com.pelissaro.librarySystem.Repository;

import br.com.pelissaro.librarySystem.Domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();

    public void addUsers(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return users;
    }
}
