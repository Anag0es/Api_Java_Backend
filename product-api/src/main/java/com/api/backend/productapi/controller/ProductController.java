package com.api.backend.productapi.controller;

import com.api.backend.productapi.dto.ProductDTO;
import com.api.backend.productapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private ProductService productService;

    // GET - Retorna uma lista de todos os produtos
    @GetMapping
    public List<ProductDTO> getProducts(){
        return productService.getAll();
    }

    // GET - retorna uma lista de produtos pela sua categoria
    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(
            @PathVariable Long categoryId){
        return productService.getProductByCategoryId(categoryId);
    }

    // GET - retorna um produto pelo seu identificador
    @GetMapping("/{productIdentifier}")
    public ProductDTO findById(
            @PathVariable String productIdentifier){
        return productService.findByProductIdentifier(productIdentifier);
    }

    // POST - salva um novo produto e retorna o mesmo produto
    @PostMapping
    public ProductDTO newProduct(
            @Valid @RequestBody ProductDTO userDTO){
        return productService.save(userDTO);
    }

    // DELETE - deleta um produto pelo id
    @DeleteMapping("/{id}")
    public ProductDTO delete(@PathVariable Long id){
        return productService.delete(id);
    }

    // POST - edita um produto pelo seu id
    @PostMapping("/{id}")
    public ProductDTO editProduct(@PathVariable Long id,
                                  @RequestBody ProductDTO productDTO){
        return productService.editProduct(id, productDTO);
    }

    // GET - retona uma pagina de produtos de acordo com a paginacao
    @GetMapping("/pageable")
    public Page<ProductDTO> getProductsPage(Pageable pageable){
        return productService.getAllPage(pageable);
    }
}
