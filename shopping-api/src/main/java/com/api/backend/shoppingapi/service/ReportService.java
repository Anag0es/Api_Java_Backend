package com.api.backend.shoppingapi.service;

import com.api.backend.shoppingapi.dto.ShopDTO;
import com.api.backend.shoppingapi.dto.ShopReportDTO;
import com.api.backend.shoppingapi.model.Shop;
import com.api.backend.shoppingapi.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public List<ShopDTO> getShopsByFilter(
            LocalDate dataInicio,
            LocalDate dataFim,
            Float valorMinimo
    ){
        List<Shop> shops = reportRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops.stream().map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(
            LocalDate dataInicio,
            LocalDate dataFim
    ){
        return reportRepository.getReportByDate(dataInicio, dataFim);
    }
}
