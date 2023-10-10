package com.api.backend.Userapi.controller;

import com.api.backend.Userapi.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @PostConstruct
    public void initializeList(){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Ana");
        userDTO.setCpf("213942");
        userDTO.setEmail("ana@test.com");
        userDTO.setTelefone("129842-39392");
        userDTO.setEndereco("Rua a");
        userDTO.setDataCadastro(LocalDateTime.now());

        usuarios.add(userDTO);
    }

    @GetMapping
    public List<UserDTO> getUsers(){
        return usuarios;
    }

    @GetMapping("/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf){
        return usuarios.stream()
                .filter(userDTO -> userDTO.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("user not found."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO inserir(@RequestBody UserDTO userDTO){
        userDTO.setDataCadastro(LocalDateTime.now());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/{cpf}")
    public boolean remover(@PathVariable String cpf){
        return usuarios.removeIf(userDTO -> userDTO.getCpf().equals(cpf));
    }

}
