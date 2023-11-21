package com.api.backend.productapi.dto;

import com.api.backend.productapi.dto.CategoryDTO;
import com.api.backend.productapi.model.Category;
import com.api.backend.productapi.model.Product;

public class DTOConverter {

    public static CategoryDTO convert(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setNome(category.getNome());
        categoryDTO.setId(category.getId());
        return categoryDTO;
    }

    public static ProductDTO convert(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(productDTO.getNome());
        productDTO.setPreco(product.getPreco());
        if(product.getCategory() != null){
            productDTO.setCategory(
                    DTOConverter.convert((Category) product.getCategory()));
        }
        return productDTO;
    }
}
