package com.api.backend.Userapi.dto;

import com.api.backend.Userapi.model.User;

public class DTOConverter {

    public static UserDTO converter(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        return userDTO;
    }
}
