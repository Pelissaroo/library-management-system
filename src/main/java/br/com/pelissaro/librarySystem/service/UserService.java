package br.com.pelissaro.librarySystem.service;

import br.com.pelissaro.librarySystem.domain.User;
import br.com.pelissaro.librarySystem.exception.UserNotFoundException;
import br.com.pelissaro.librarySystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void registerUser(User user){
        userRepository.saveAndFlush(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Integer id){
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void deleteUser(Integer id){
        User user = findUserById(id);
        userRepository.delete(user);
    }

    public void updateUserById(Integer id, User user){
        User userEntity = findUserById(id);
        User userUpdated = User.builder()
                .id(userEntity.getId())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .cpf(user.getCpf() != null ? user.getCpf() : userEntity.getCpf())
                .address(user.getAddress() != null ? user.getAddress() : userEntity.getAddress())
                .addressNumber(user.getAddressNumber() != 0 ? user.getAddressNumber() : userEntity.getAddressNumber())
                .phoneNumber(user.getPhoneNumber() != null ? user.getPhoneNumber() : userEntity.getPhoneNumber())
                .build();
        userRepository.saveAndFlush(userUpdated);
    }
}
