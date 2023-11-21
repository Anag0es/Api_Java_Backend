package com.api.backend.shoppingapi.dto;

import com.api.backend.shoppingapi.model.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    // atributos do item
    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

}
