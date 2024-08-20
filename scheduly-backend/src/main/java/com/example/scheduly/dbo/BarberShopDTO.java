package com.example.scheduly.dbo;

import com.example.scheduly.entity.BarberShopEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
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
public class BarberShopDTO {
    private UUID id;
    private String name;
    private String photo;
    private String email;
    private String phone;
    private Andress andress = new Andress();
    private Timestamp dateCreated;

    public BarberShopDTO() {}

    public BarberShopDTO(BarberShopEntity shop) {
        BeanUtils.copyProperties(shop, this);
        if (shop.getAndress() != null) {
            // Se não for nulo, copia manualmente as propriedades de `Andress`
            BeanUtils.copyProperties(shop.getAndress(), this.andress);
        }
    }

}
