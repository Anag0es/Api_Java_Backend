package com.api.backend.Userapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "nome é obrigatório")
    private String nome;
    @NotBlank(message = "cpf é obrigatório")
    private String cpf;
    @NotBlank(message = "endereco é obrigatório")
    private String endereco;
    @NotBlank(message = "e-mail é obrigatório")
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
}
