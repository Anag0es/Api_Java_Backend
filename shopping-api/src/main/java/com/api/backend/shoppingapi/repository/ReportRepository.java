package com.api.backend.shoppingapi.repository;

import com.api.backend.shoppingapi.dto.ShopReportDTO;
import com.api.backend.shoppingapi.model.Shop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// Anota a interface como um repositório JPA gerenciado pelo Spring
public interface ReportRepository {

    // define um metodo para filtrar as compras pelos filtros: data e valor minimo
    public List<Shop> getShopByFilters(
            LocalDate dataInicio,
            LocalDate dataFim,
            Float valorMinimo
    );


    // define um metodo para retornar a partir da data as estatisticas da compra
    public ShopReportDTO getReportByDate(
            LocalDate dataInicio,
            LocalDate dataFim
    );
}
