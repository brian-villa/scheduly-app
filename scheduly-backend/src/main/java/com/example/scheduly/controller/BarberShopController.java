package com.example.scheduly.controller;

import com.example.scheduly.dbo.BarberShopDTO;
import com.example.scheduly.dbo.UserDTO;
import com.example.scheduly.service.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/barbershop")
public class BarberShopController {
    @Autowired
    private BarberShopService barberShopService;

    @GetMapping
    public List<BarberShopDTO> listAll() {
        return barberShopService.listAllShops();
    }

    @PostMapping
    public void insertShop(@RequestBody BarberShopDTO barberShopDTO) {
        barberShopService.insert(barberShopDTO);
    }

    @PutMapping
    public BarberShopDTO changeShop(@RequestBody BarberShopDTO barberShopDTO) {
        return barberShopService.change(barberShopDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable("id") UUID id) {
        barberShopService.delete(id);
        return ResponseEntity.ok().build();
    }
}
