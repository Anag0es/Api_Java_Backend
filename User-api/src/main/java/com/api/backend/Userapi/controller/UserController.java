package com.api.backend.Userapi.controller;

import com.api.backend.Userapi.dto.UserDTO;
import com.api.backend.Userapi.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// codigo para  definir os endpoints da API
@RestController
// definir caminho base
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    // atributo que representa o servico de usuarios
    private final UserService userService;


    // endpoint para retornar todos os usuarios
    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getAll();
    }

    // endpoint para retornar o usuario a partir do Id
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }

    //endpoint para criar um novo usuario a partir dos dados que receber
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO newUser(@RequestBody @Valid UserDTO userDTO){
        return userService.save(userDTO);
    }

    //endpoint que retorna um usuario pelo seu CPF
    @GetMapping("/{cpf}/cpf")
    public UserDTO findByCpf(@PathVariable String cpf,
                             @RequestParam(name = "key", required = true)String key){
        return userService.findByCpf(cpf, key);
    }

    // endpoint que remove um usuario pelo seu Id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    // endpoint que retorna uma lista de usuários que tenham o nome ou parte do nome informado
    @GetMapping("/search")
    public List<UserDTO> queryByName(
            @RequestParam(name = "nome", required = true)String nome){
        return userService.queryByName(nome);
    }

    // endpoint que atualiza os dados informados de um usuario cadastrado
    @PatchMapping("/{id}")
    public UserDTO editUser(@PathVariable Long id,
                            @RequestBody UserDTO userDTO){
        return userService.editUser(id, userDTO);
    }

    // endpoint que retorna uma pagina de usuarios de acordo com as informacoes de paginacao recebidas
    @GetMapping("/pageable")
    public Page<UserDTO> getUserPage(Pageable page){
        return userService.getAllPage(page);
    }

}
