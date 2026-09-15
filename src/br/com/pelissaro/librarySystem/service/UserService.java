package br.com.pelissaro.librarySystem.service;

import br.com.pelissaro.librarySystem.domain.User;
import br.com.pelissaro.librarySystem.exception.NoUsersFoundException;
import br.com.pelissaro.librarySystem.exception.UserNotFoundException;
import br.com.pelissaro.librarySystem.repository.userRepository;

import java.util.List;

public class UserService {
    userRepository userRepository = new userRepository();

    public void registerUser(String name, String cpf, String address, int addressNumber, String phoneNumber){
        User user = new User(name, cpf, address, addressNumber, phoneNumber);
        userRepository.addUsers(user);
    }

    public void showUsers(){
        List<User> findUsers = userRepository.findAll();
        if (findUsers.isEmpty()){
            throw new NoUsersFoundException();
        }
        for (User users: findUsers){
            System.out.println(users);
        }
    }

    public User findUserByID(int id){
        if (id < 1) {
            throw new IllegalArgumentException("ID cannot be less than 0");
        }
        User user = userRepository.findById(id);
        if (user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    public void validateInputString (String string){
        if (!string.matches("^[\\p{L}\\s]+$")){
            throw new IllegalArgumentException();
        }
    }

    public void validateCpf(String string){
        if (!string.matches("^\\d{11}$")){
            throw new IllegalArgumentException();
        }
    }

    public void validatePhoneNumber(String string){
        if (!string.matches("^\\d{11}$")){
            throw new IllegalArgumentException();
        }
    }

    public void updateName(User user, String name) {
        userRepository.updateName(user,name);
    }

    public void updateCPF(User user, String cpf){
        userRepository.updateCPF(user,cpf);
    }

    public void updateAddress(User user, String address){
        userRepository.updateAddress(user,address);
    }

    public void updateAddressNumber(User user, int addressNumber){
        userRepository.updateAddressNumber(user,addressNumber);
    }

    public void updatePhoneNumber(User user, String phoneNumber){
        userRepository.updatePhoneNumber(user,phoneNumber);
    }

    public void deleteUser(User user){
        userRepository.deleteUser(user);
    }
}
