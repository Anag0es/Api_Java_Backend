package com.api.backend.Userapi.dto;

import com.api.backend.Userapi.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// representa os dados do usuario
// transfere dados entre controlador e servico
// transfere dados entre servico de usuario e banco de dados
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    //atributo para armazenar o nome do usuario
    @NotBlank(message = "nome é obrigatório")
    private String nome;
    // atributo para armazenar o cpf do usuario
    @NotBlank(message = "cpf é obrigatório")
    private String cpf;
    // atributo para armazenar o endereco do usuario
    @NotBlank(message = "endereco é obrigatório")
    private String endereco;
    // atributo para armazenar o email do usuario
    @NotBlank(message = "e-mail é obrigatório")
    private String email;
    // atributo para armazenar o telefone do usuario
    private String telefone;
    // atributo para armazenar a data de cadastro do usuario
    private LocalDateTime dataCadastro;
    private String key;


}
