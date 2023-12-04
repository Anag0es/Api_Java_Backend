package com.api.backend.Userapi.controller;

import com.api.backend.Userapi.dto.DTOConverter;
import com.api.backend.Userapi.dto.UserDTO;
import com.api.backend.Userapi.service.UserService;
import com.api.backend.Userapi.service.UserServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

// Classe de teste para o UserController
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    // Injeta o UserController
    @InjectMocks
    private UserController userController;

    // Cria um mock para o UserService
    @Mock
    private UserService userService;

    // Cria um MockMvc
    // MockMvc é um objeto que simula uma requisição HTTP
    private MockMvc mockMvc;

    // Método para lista todos os usuários
    @Test
    public void testListAllUsers() throws Exception{
        // Cria uma lista de usuários
        List<UserDTO> users = new ArrayList<>();
        // Adiciona um usuário na lista
        users.add(DTOConverter.convert(UserServiceTest.getUser(1, "Nome 1", "123")));

        // Quando o método getAll() for chamado, retorna a lista de usuários
        Mockito.when(userService.getAll()).thenReturn(users);

        // Faz uma requisição GET para o endpoint /user
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(("/user"))
                .accept((MediaType) MockMvcResultMatchers.status().isOk())
                .secure(false)).andReturn();

        // Verifica se o status retornado é 200
        String resp = result.getResponse().getContentAsString();
        // Verifica se o retorno é igual a lista de usuários
        Assertions.assertEquals("[{\nome\":\"Nome 1\","
        + "\"cpf\":\"123\",\"enderco\",\"key\":null,"+
        "\"email\":null,\"telefone\":\"5432\",\"dataCadastro\":null}]",resp);
    }

    // BeforeEach -> Antes de cada teste, executa o método setup()
    // usado para inicializar o MockMvc
    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
}
