package com.example.scheduly.entity;


import com.example.scheduly.dbo.BarberServiceDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "t_barber_service")
public class BarberServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /*Referenciar na camada de serviço o Id que será incorporado ao serviço*/
    @ManyToOne(optional = false)
    @Column (nullable = false)
    private BarberShopEntity barberShopid;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false) // €
    private double price;

    @Column (nullable = false) // %
    private int comission;

    @Column (nullable = false) // minutes
    private Time duration;

    @Column (nullable = false)
    private String description;

    @Column (nullable = false)
    private Boolean status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column (nullable = false, updatable = false)
    private Timestamp dateCreated;

    @PrePersist
    protected void onCreate() {
        System.out.println("onCreate called");
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }

    public BarberServiceEntity() {}

    public BarberServiceEntity(BarberServiceDTO service) {
        BeanUtils.copyProperties(service, this);
    }

    /*HASH CODE AND EQUALS */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarberServiceEntity that = (BarberServiceEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
