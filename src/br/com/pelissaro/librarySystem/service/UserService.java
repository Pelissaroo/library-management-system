package br.com.pelissaro.librarySystem.service;

import br.com.pelissaro.librarySystem.domain.User;
import br.com.pelissaro.librarySystem.exception.NoUsersFoundException;
import br.com.pelissaro.librarySystem.exception.UserNotFoundException;
import br.com.pelissaro.librarySystem.repository.userRepository;

import java.util.List;

public class UserService {
    userRepository userRepository = new userRepository();
    private static int nextID;

    public void registerUser(String name, String cpf, String adress, int adressNumber, String phoneNumber){
        User user = new User(name, ++nextID, cpf, adress, adressNumber, phoneNumber);
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
        user.setName(name);
    }

    public void updateCPF(User user, String cpf){
        user.setCpf(cpf);
    }

    public void updateAddress(User user, String address){
        user.setAddress(address);
    }

    public void updateAddressNumber(User user, int addressNumber){
        user.setAddressNumber(addressNumber);
    }

    public void updatePhoneNumber(User user, String phoneNumber){
        user.setPhoneNumber(phoneNumber);
    }
}
