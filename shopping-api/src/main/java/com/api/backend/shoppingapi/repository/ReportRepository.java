package com.api.backend.shoppingapi.repository;

import com.api.backend.shoppingapi.dto.ShopReportDTO;
import com.api.backend.shoppingapi.model.Shop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(
            LocalDate dataInicio,
            LocalDate dataFim,
            Float valorMinimo
    );


    public ShopReportDTO getReportByDate(
            LocalDate dataInicio,
            LocalDate dataFim
    );
}
