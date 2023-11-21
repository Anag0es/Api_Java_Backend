package com.api.backend.shoppingapi.repository;

import com.api.backend.shoppingapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {

    // define um metodo para o filtro de compra para um usuario especifico
    public List<Shop> findAllByUserIdentifier(String userIdentifier);

    // define um metodo para o filtro das compras a partir de um valor maior que
    public List<Shop> findAllByTotalGreaterThan(Float total);

    // define um metodo para o filtro das compras a partir de uma data maior que
    List<Shop> findAllByDateGreaterThan(LocalDateTime date);
}
