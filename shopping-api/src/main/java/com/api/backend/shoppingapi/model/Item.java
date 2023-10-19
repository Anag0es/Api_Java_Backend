package com.api.backend.shoppingapi.model;

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

    private String productidentifier;
    private Float price;

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductidentifier(
                itemDTO.getProductIdentifier()
        );
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
