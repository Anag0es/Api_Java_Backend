package com.api.backend.shoppingapi.service;

import com.api.backend.Userapi.dto.UserDTO;
import com.api.backend.shoppingapi.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private String userApiUrl = "http://localhost:8080";

    public UserDTO getUserByCpf(String cpf, String key){
        try{
            WebClient webClient = WebClient.builder()
                    .baseUrl(userApiUrl).build();

            Mono<UserDTO> user = webClient.get()
                    .uri("/user/" + cpf + "/cpf?key=" + key)
                    .retrieve()
                    .bodyToMono(UserDTO.class);

            return user.block();
        } catch (Exception e){
            throw new UserNotFoundException();
        }
    }
}
