package com.example.scheduly.service;

import com.example.scheduly.dbo.BarberServiceDTO;
import com.example.scheduly.entity.BarberServiceEntity;
import com.example.scheduly.repository.BarberServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberServiceService {
    @Autowired
    private BarberServiceRepository serviceRepository;
    @Autowired
    private BarberServiceRepository barberServiceRepository;

    public List<BarberServiceDTO> listAllService() {
        List<BarberServiceEntity> services = serviceRepository.findAll();

        return services.stream().map(BarberServiceDTO::new).toList();
    }

    public void insert(BarberServiceDTO dto) {
        BarberServiceEntity entity = new BarberServiceEntity(dto);

        //ADICIONAR O ID DE UMA BARBEARIA EXISTENTE AQUI NA HORA DE CRIAR UM NOVO SERVIÇO
        barberServiceRepository.save(entity);
    }


}
