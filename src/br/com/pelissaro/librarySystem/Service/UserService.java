package br.com.pelissaro.librarySystem.Service;

import br.com.pelissaro.librarySystem.Domain.User;
import br.com.pelissaro.librarySystem.Repository.userRepository;

public class UserService {
    userRepository userRepository = new userRepository();
    private static int nextID;

    public void registerUser(String name, String cpf, String adress, int adressNumber, String phoneNumber){
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
