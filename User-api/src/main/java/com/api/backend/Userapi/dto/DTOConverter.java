package com.api.backend.Userapi.dto;

import com.api.backend.Userapi.model.User;

public class DTOConverter {

    // Método que converte um objeto User em um objeto UserDTO
    public static UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setKey(user.getKey());
        // Retorna o objeto UserDTO
        return userDTO;
    }
}
