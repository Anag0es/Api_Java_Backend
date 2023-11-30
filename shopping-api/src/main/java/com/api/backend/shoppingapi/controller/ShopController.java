package com.api.backend.shoppingapi.controller;

import com.api.backend.shoppingapi.dto.ShopDTO;
import com.api.backend.shoppingapi.service.ShopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// classe para definir rotas do microsservico
@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ShopService service;

    // GET - metodo que retorna uma lista de todas as compras
    @GetMapping("/shopping")
    public List<ShopDTO> getShops(){
        return service.getAll();
    }

    // GET - metodo que retorna as compras de um usuario especifico
    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier){
        return service.getByUser(userIdentifier);
    }

    // GET - metodo que retorna as compras de uma certa data
    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO){
        return service.getByDate(shopDTO);
    }

    // GET - metodo que retorna uma determinada compra pelo id
    @GetMapping("shopping/{id}")
    public ShopDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    // POST - metodo que salva uma compra
    @PostMapping("/shopping")
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO,
                           @RequestHeader(name = "key", required = true) String key){
        return service.save(shopDTO, key);
    }
}
