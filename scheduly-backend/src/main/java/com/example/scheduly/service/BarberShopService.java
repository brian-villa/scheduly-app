package com.example.scheduly.service;

import com.example.scheduly.dbo.BarberShopDTO;
import com.example.scheduly.entity.BarberShopEntity;
import com.example.scheduly.repository.BarberShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BarberShopService {
    @Autowired
    private BarberShopRepository barberShopRepository;

    public List<BarberShopDTO> listAllShops() {
        List<BarberShopEntity> shops = barberShopRepository.findAll();

        return shops.stream().map(BarberShopDTO::new).toList();
    }

    public void insert(BarberShopDTO barberShopDTO) {
        BarberShopEntity barberShopEntity = new BarberShopEntity(barberShopDTO);
        barberShopRepository.save(barberShopEntity);
    }

    public BarberShopDTO change(BarberShopDTO barberShopDTO) {
        BarberShopEntity barberShopEntity = new BarberShopEntity(barberShopDTO);

        return new BarberShopDTO(barberShopRepository.save(barberShopEntity));
    }

    public void delete(UUID id) {
        BarberShopEntity barberShopEntity = barberShopRepository.findById(id).get();

        barberShopRepository.delete(barberShopEntity);
    }

    public BarberShopDTO findById(UUID id) {
        return new BarberShopDTO(barberShopRepository.findById(id).get());
    }
}
