package com.api.backend.Userapi.service;

import com.api.backend.Userapi.dto.DTOConverter;
import com.api.backend.Userapi.dto.UserDTO;
import com.api.backend.Userapi.model.User;
import com.api.backend.Userapi.repository.UserRepository;
import com.api.backend.shoppingapi.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

// classe que implementa a logica de negocio relacionada ao usuario
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

// Define um metodo para retornar uma lista de todos os usuarios convertidos em UserDTO
    public List<UserDTO> getAll(){
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    // Define um metodo para retornar um usuario específico pelo id convertido em UserDTO
    public UserDTO findById(long userId){
        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found."));
        return DTOConverter.convert(usuario);
    }

    // Define um metodo para salvar um novo usuario no banco de dados a partir de um UserDTO
    public UserDTO save(UserDTO userDTO){
        userDTO.setKey(UUID.randomUUID().toString());
        userDTO.setDataCadastro(LocalDateTime.now());
        User user = userRepository.save(User.convert(userDTO));
        return DTOConverter.convert(user);
    }

// Define um metodo para deletar um usuario a partir do seu id
    public UserDTO delete(long userId){
        User user = userRepository
                .findById(userId).orElseThrow(() ->
                        new RuntimeException());
        userRepository.delete(user);
        return DTOConverter.convert(user);
    }

// Define um metodo para retornar um usuario a partir do seu cpf
    public UserDTO findByCpfAndKey(String cpf, String key){
        User user = userRepository.findByCpfAndKey(cpf, key);
        if(user != null){
            return DTOConverter.convert(user);
        }
        throw new UserNotFoundException();
    }

// Define um metodo para retornar o usuario a partir do seu nome convertido em uma lista dto
    public List<UserDTO> queryByName(String name){
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

// Define um metodo para editar um usuario a partir do seu id
    public UserDTO editUser(Long userId, UserDTO userDTO){
        User user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException());

        // condicionais para verificar se sao nulos o email, telefone e endereco
        if (userDTO.getEmail() != null &&
                !user.getEmail().equals(userDTO.getEmail())){
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getTelefone() != null &&
                !user.getTelefone().equals(userDTO.getTelefone())){
            user.setTelefone(userDTO.getTelefone());
        }
        if (userDTO.getEndereco() != null &&
                !user.getEndereco().equals(userDTO.getEndereco())){
            user.setEndereco(userDTO.getEndereco());
        }

        user = userRepository.save(user);
        return DTOConverter.convert(user);

    }

// Define um metodo para retornar uma pagina de um usuario convertido em dto
    public Page<UserDTO> getAllPage(Pageable page){
        Page<User> users = userRepository.findAll(page);
        return users.map(DTOConverter::convert);
    }
}
