package com.example.scheduly.entity;

import com.example.scheduly.dbo.BarberShopDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@Embeddable
class Andress {
    /* Atributes */
    private String street;
    private String number;
    private String city;
    private String district;
    private String zip;
    private String country;

    /*Constructor*/
    public Andress() {}
}

@Setter
@Getter
@Entity
@Table(name = "t_barberShop")
public class BarberShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String photo;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String phone;

    @Embedded
    @Column (nullable = false)
    private Andress andress = new Andress();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(nullable = false, updatable = false)
    private Timestamp dateCreated;

    @PrePersist
    protected void onCreate() {
        System.out.println("onCreate called");
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }

    public BarberShopEntity() {}

    public BarberShopEntity(BarberShopDTO shop) {
        BeanUtils.copyProperties(shop, this);

        if (shop.getAndress() != null) {
            // Se não for nulo, copia manualmente as propriedades de `Andress`
            BeanUtils.copyProperties(shop.getAndress(), this.andress);
        }
    }

    /*HASH CODE AND EQUALS */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarberShopEntity that = (BarberShopEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
