package com.api.backend.Userapi.model;

import com.api.backend.Userapi.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// classe que representa um usuario
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    // Anota o campo id como uma chave primária gerada automaticamente pelo banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // declara os campos que o usuario tem
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    // metodo estatico para converter um objeto UserDTO em um objeto User
    public static User convert(UserDTO userDTO){
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setCpf(userDTO.getCpf());
        user.setEmail(userDTO.getEmail());
        user.setEndereco(userDTO.getEndereco());
        user.setTelefone(userDTO.getTelefone());
        user.setDataCadastro(userDTO.getDataCadastro());
        return user;
    }

}
