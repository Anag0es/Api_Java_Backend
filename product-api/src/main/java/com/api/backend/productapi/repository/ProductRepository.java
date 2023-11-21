package com.api.backend.productapi.repository;

import com.api.backend.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// Anota a interface como um repositório JPA gerenciado pelo Spring
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // query sql para filtrar o produto por sua categoria
    @Query(value = "select p"
    + "from product p"
    + "join category c on p.category.id = c.id"
    + "where c.id = :categoryId")
    public List<Product> getProductByCategory(
            @Param("categoryId") long categoryId);

    // define um metodo para buscar o produto por sua identificacao
    public Product findByProductIdentifier(
            String productIdentifier);
}
