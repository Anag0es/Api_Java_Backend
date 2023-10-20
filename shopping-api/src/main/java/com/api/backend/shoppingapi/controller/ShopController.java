package com.api.backend.shoppingapi.controller;

import com.api.backend.shoppingapi.dto.ShopDTO;
import com.api.backend.shoppingapi.service.ShopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ShopService service;

    @GetMapping("/shopping")
    public List<ShopDTO> getShops(){
        return service.getAll();
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier){
        return service.getByUser(userIdentifier);
    }

    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO){
        return service.getByDate(shopDTO);
    }

    @GetMapping("shopping/{id}")
    public ShopDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/shopping")
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO){
        return service.save(shopDTO);
    }
}
