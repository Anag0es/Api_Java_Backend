package com.api.backend.productapi.dto;

import com.api.backend.productapi.dto.CategoryDTO;
import com.api.backend.productapi.model.Category;
import com.api.backend.productapi.model.Product;

public class DTOConverter {

    public static CategoryDTO converter(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setNome(category.getNome());
        categoryDTO.setId(category.getId());
        return categoryDTO;
    }

    public static ProductDTO converter(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(productDTO.getNome());
        productDTO.setPreco(product.getPreco());
        if(product.getCategory() != null){
            productDTO.setCategory(
                    DTOConverter.converter((Category) product.getCategory()));
        }
        return productDTO;
    }
}
