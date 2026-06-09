package br.com.pelissaro.librarySystem.Service;

import br.com.pelissaro.librarySystem.Domain.User;
import br.com.pelissaro.librarySystem.Repository.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public void CadasterUser(String name, String cpf, String adress, int adressNumber, String phoneNumber){
        User user = new User(name,cpf,adress,adressNumber,phoneNumber);
        userRepository.addUsers(user);
    }

    public void showUsers(){
        for (User users: userRepository.findAll()){
            System.out.println(users);
        }
    }
}
