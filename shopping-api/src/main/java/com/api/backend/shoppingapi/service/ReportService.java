package com.api.backend.shoppingapi.service;

import com.api.backend.shoppingapi.dto.DTOConverter;
import com.api.backend.shoppingapi.dto.ShopDTO;
import com.api.backend.shoppingapi.dto.ShopReportDTO;
import com.api.backend.shoppingapi.model.Shop;
import com.api.backend.shoppingapi.repository.ReportRepository;
import com.api.backend.shoppingapi.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ShopRepository reportRepository;

    // metodo para retornar uma lista de dto das compras pelo filtro: data e valor
    public List<ShopDTO> getShopsByFilter(
            LocalDate dataInicio,
            LocalDate dataFim,
            Float valorMinimo
    ){
        List<Shop> shops = reportRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops.stream().map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    // metodo para retornar uma compra a partir de uma data
    public ShopReportDTO getReportByDate(
            LocalDate dataInicio,
            LocalDate dataFim
    ){
        return reportRepository.getReportByDate(dataInicio, dataFim);
    }
}
