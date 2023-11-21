package com.api.backend.productapi.service;

import com.api.backend.productapi.dto.DTOConverter;
import com.api.backend.productapi.dto.ProductDTO;
import com.api.backend.productapi.model.Product;
import com.api.backend.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// classe que implementa a logica de negocio relacionada ao produto
@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    // define um metodo para retonar todos os produtos em uma lista
    public List<ProductDTO> getAll(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    // define um metodo para retornar uma lista de produtos pela categoria
    public List<ProductDTO> getProductByCategoryId(Long categoryId){
        List<Product> products = productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    // define um metodo para retornar um produto pela sua identificacao
    public ProductDTO findByProductIdentifier(String productIdentifier){
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null){
            return DTOConverter.convert(product);
        }
        return null;
    }

    // define um metodo para salvar um novo produto
    public ProductDTO save(ProductDTO productDTO){
        Product product = productRepository.save(Product.convert(productDTO));
        return DTOConverter.convert(product);
    }

    // define um metodo para deletar um produto a partir do seu id
    public ProductDTO delete(long productId){
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()){
            productRepository.delete(product.get());
        }
        return null;
    }

    // define um metodo para editar um produto a partir do seu id
    public ProductDTO editProduct(long id, ProductDTO dto){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (dto.getNome() != null || !dto.getNome().isEmpty()){
            product.setNome(dto.getNome());
        }
        if (dto.getPreco() != null){
            product.setPreco(dto.getPreco());
        }
        return DTOConverter.convert(productRepository.save(product));
    }


    // define um metodo para retornar os produtos em paginacao
    public Page<ProductDTO> getAllPage(Pageable page){
        Page<Product> users = productRepository.findAll(page);
        return users.map(DTOConverter::convert);
    }
}
