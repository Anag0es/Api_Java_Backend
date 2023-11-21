package com.api.backend.productapi.model;

import com.api.backend.productapi.dto.ProductDTO;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// classe que representa um produto
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product {

    // atributos do produto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float preco;
    private String descricao;
    private String productIdentifier;

    // acao com banco de dados
    // juncao muitos para um
    // join
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
