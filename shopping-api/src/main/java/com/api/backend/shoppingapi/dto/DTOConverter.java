package com.api.backend.shoppingapi.dto;

import com.api.backend.shoppingapi.model.Item;
import com.api.backend.shoppingapi.model.Shop;

import java.util.stream.Collectors;

public class DTOConverter {

    // metodo que retorna um item em dto
    public static ItemDTO convert(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setPrice(item.getPrice());
        itemDTO.setProductIdentifier(item.getProductidentifier());
        return itemDTO;
    }

    // metodo que retorna um shop em dto
    public static ShopDTO convert(Shop shop){
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getDate());
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setItems(shop.getItems()
                .stream().map(DTOConverter::convert)
                .collect(Collectors.toList()));
        return shopDTO;
    }
}
