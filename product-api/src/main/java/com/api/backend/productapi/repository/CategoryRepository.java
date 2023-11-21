package com.api.backend.productapi.repository;

import com.api.backend.productapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Anota a interface como um repositório JPA gerenciado pelo Spring
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
