package br.com.pelissaro.librarySystem.repository;

import br.com.pelissaro.librarySystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    void deleteById(Integer id);


}
