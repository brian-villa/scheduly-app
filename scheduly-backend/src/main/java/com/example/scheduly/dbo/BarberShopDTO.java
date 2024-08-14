package com.example.scheduly.dbo;

import com.example.scheduly.entity.BarberShopEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

class Andress {
    /* Atributes */
    private String street;
    private String number;
    private String city;
    private String district;
    private String zip;
    private String country;

    /*Getters and Setters */
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    /*Constructor*/
    public Andress() {}

    public Andress(String street, String number, String city, String district, String zip, String country) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.district = district;
        this.zip = zip;
        this.country = country;
    }
}

class Geo {
    private String type;

    @ElementCollection
    private List<String> coordinate;

    /*getters and setters */

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(List<String> coordinate) {
        this.coordinate = coordinate;
    }

    public Geo() {}

    public Geo(String type, List<String> coordinate) {
        this.type = type;
        this.coordinate = coordinate;
    }


}

public class BarberShopDTO {
    private UUID id;
    private String name;
    private String photo;
    private String email;
    private String phone;
    private Andress andress;
    private Geo geo;
    private Date dateCreated;

    public BarberShopDTO() {}

    public BarberShopDTO(BarberShopEntity shop) { BeanUtils.copyProperties(shop, this); }

    /* Getters and Setters */
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Andress getAndress() {
        return andress;
    }

    public void setAndress(Andress andress) {
        this.andress = andress;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
