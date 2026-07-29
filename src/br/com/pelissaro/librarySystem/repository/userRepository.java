package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.domain.User;

import java.util.ArrayList;
import java.util.List;

public class userRepository {
    private ArrayList<User> users = new ArrayList<>();

    public void addUsers(User user) {
        users.add(user);
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
