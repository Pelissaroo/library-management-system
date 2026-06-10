package br.com.pelissaro.librarySystem.Service;

import br.com.pelissaro.librarySystem.Domain.User;
import br.com.pelissaro.librarySystem.Repository.userRepository;

public class userService {
    userRepository userRepository = new userRepository();
    private static int nextID;

    public void CadasterUser(String name, String cpf, String adress, int adressNumber, String phoneNumber){
        User user = new User(name, ++nextID, cpf, adress, adressNumber, phoneNumber);
        userRepository.addUsers(user);
    }

    public void showUsers(){
        for (User users: userRepository.findAll()){
            System.out.println(users);
        }
    }

    public User findUserByID(int id){
        return userRepository.findById(id);
    }
}
