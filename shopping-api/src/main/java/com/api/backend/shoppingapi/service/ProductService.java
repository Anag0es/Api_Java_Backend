package com.api.backend.shoppingapi.service;

import com.api.backend.productapi.dto.ProductDTO;
import com.api.backend.shoppingapi.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private String productApiUrl = "http://localhost:8081";

    public ProductDTO getProductByIdentifier(String productIdentifier){
        try{
            WebClient webClient = WebClient.builder()
                    .baseUrl(productApiUrl)
                    .build();

            Mono<ProductDTO> product = webClient.get()
                    .uri("/product/" + productIdentifier)
                    .retrieve()
                    .bodyToMono(ProductDTO.class);

            return product.block();
        }catch (Exception e){
            throw new ProductNotFoundException();
        }
    }
}
