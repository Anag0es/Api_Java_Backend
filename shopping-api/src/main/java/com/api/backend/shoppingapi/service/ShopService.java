package com.api.backend.shoppingapi.service;

import com.api.backend.shoppingapi.dto.DTOConverter;
import com.api.backend.shoppingapi.dto.ShopDTO;
import com.api.backend.shoppingapi.model.Shop;
import com.api.backend.shoppingapi.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    // metodo para retornar todas as compras
    public List<ShopDTO> getAll(){
        List<Shop> shops = shopRepository.findAll();
        return shops.stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    // metodo para retornar uma lista de compras por um determinado usuario
    public List<ShopDTO> getByUser(String userIdentifier){
        List<Shop> shops = shopRepository
                .findAllByUserIdentifier(userIdentifier);
        return shops.stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    // metodo para retornar uma lista de compras pela data especificada
    public List<ShopDTO> getByDate(ShopDTO shopDTO){
        List<Shop> shops = shopRepository.findAllByDateGreaterThan(
                shopDTO.getDate()
        );
        return shops.stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    // metodo para retornar uma compra a partir de um id
    public ShopDTO findById(long ProductId){
        Optional<Shop> shop = shopRepository.findById(ProductId);
        if (shop.isPresent()){
            return DTOConverter.convert(shop.get());
        }
        return null;
    }

    // metodo para salvar uma compra
    public ShopDTO save(ShopDTO shopDTO){
        shopDTO.setTotal(shopDTO.getItems()
                .stream()
                .map(x -> x.getPrice())
                .reduce((float) 0, Float::sum));

        Shop shop = new Shop();
        shop.setDate(LocalDateTime.now());

        shop = shopRepository.save(shop);
        return DTOConverter.convert(shop);
    }
}
