package com.api.backend.shoppingapi.dto;

import com.api.backend.shoppingapi.model.Item;
import com.api.backend.shoppingapi.model.Shop;

import java.util.stream.Collectors;

public class DTOConverter {

    public static ItemDTO converter(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setPrice(item.getPrice());
        itemDTO.setProductIdentifier(item.getProductidentifier());
        return itemDTO;
    }

    public static ShopDTO converter(Shop shop){
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getDate());
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setItems(shop.getItems()
                .stream().map(DTOConverter::converter)
                .collect(Collectors.toList()));
        return shopDTO;
    }
}
