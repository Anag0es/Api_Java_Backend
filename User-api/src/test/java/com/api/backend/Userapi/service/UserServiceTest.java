package com.api.backend.Userapi.service;

import com.api.backend.Userapi.dto.DTOConverter;
import com.api.backend.Userapi.dto.UserDTO;
import com.api.backend.Userapi.model.User;
import com.api.backend.Userapi.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Classe de teste para o UserService
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // Injeta o UserService
    @InjectMocks
    private UserService userService;

    // Cria um mock para o UserRepository
    @Mock
    private UserRepository userRepository;

    // Método para criar um User
    public static User getUser(Integer id, String nome, String cpf){
        User user = new User();
        user.setId(id);
        user.setNome(nome);
        user.setCpf(cpf);
        return user;
    }


    // Testes unitários
    // Teste para listar todos os usuários
    @Test
    public void testListAllUsers(){
        List<User> users = new ArrayList<>();
        users.add(getUser(1, "João", "12345678900"));
        users.add(getUser(2, "Maria", "98765432100"));

        // Quando o método findAll() for chamado, retorna a lista de usuários
        Mockito.when(userRepository.findAll()).thenReturn(users);

        // Chama o método getAll() do UserService
        List<UserDTO> usersReturn = userService.getAll();
        Assertions.assertEquals(users.size(), usersReturn.size());
    }

    // Teste para listar um usuário pelo id
    @Test
    public void testSaveUser(){
        User userDB = getUser(1, "User name", "12345678900");
        UserDTO userDTO = DTOConverter.convert(userDB);

        // Quando o método save() for chamado, retorna o usuário
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(userDB);

        // Chama o método save() do UserService
        UserDTO user = userService.save(userDTO);
        Assertions.assertEquals(userDTO.getNome(), user.getNome());
        Assertions.assertEquals("123", user.getCpf());

    }

    // Teste para listar um usuário pelo id
    @Test
    public void testEditUser(){
        User userDB = getUser(1, "User name", "12345678900");

        // Quando o método findById() for chamado, retorna o usuário
        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.of(userDB));
        // Quando o método save() for chamado, retorna o usuário
        Mockito.when(userRepository.save(Mockito.any()))
                .thenReturn(userDB);

        // Chama o método editUser() do UserService
        UserDTO userDTO = DTOConverter.convert(userDB);
        userDTO.setEndereco("Novo endereco");
        userDTO.setTelefone("1234");

        // Chama o método editUser() do UserService
        UserDTO user = userService.editUser(1L, userDTO);
        Assertions.assertEquals("Novo endereco",user.getEndereco());
        Assertions.assertEquals("1234",user.getTelefone());
    }
}
