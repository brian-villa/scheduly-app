package com.example.scheduly.dbo;


import com.example.scheduly.entity.BarberServiceEntity;
import com.example.scheduly.entity.BarberShopEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class BarberServiceDTO {
    private UUID id;
    private String title;
    private double price;
    private int comission;
    private Time duration;
    private String description;
    private Boolean status;
    private Timestamp dateCreated;

    @ManyToOne(optional = false)
    private BarberShopEntity barberShopid;

    @PrePersist
    protected void onCreate() {
        System.out.println("onCreate called");
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }

    public BarberServiceDTO() {}

    public BarberServiceDTO(BarberServiceEntity service){
        BeanUtils.copyProperties(service, this);
    }
}
