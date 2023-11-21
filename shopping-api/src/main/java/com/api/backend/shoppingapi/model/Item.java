package com.api.backend.shoppingapi.model;

import com.api.backend.shoppingapi.dto.ItemDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Item {

    // declara os campos que o item tem
    private String productidentifier;
    private Float price;

    // metodo que converte um dto para o item
    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductidentifier(
                itemDTO.getProductIdentifier()
        );
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
