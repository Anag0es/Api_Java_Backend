package com.api.backend.Userapi.repository;

import com.api.backend.Userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Anota a interface como um repositório JPA gerenciado pelo Spring
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Define um método para buscar um usuário pelo CPF
    User findByCpf(String cpf);

    // Define um método para buscar uma lista de usuários pelo nome
    List<User> queryByNomeLike(String name);
}
