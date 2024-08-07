package com.example.scheduly.entity;

import com.example.scheduly.dbo.UserDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "t_user")
public class UserEntity {
    /* Class Atributes */
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

    @Column (nullable = false, unique = true)
    private String login;

    @Column (nullable = false)
    private String pwd;

    public UserEntity(UserDTO user) {
        BeanUtils.copyProperties(user, this);
    }

    public UserEntity () {

    }

    /* Getter and Setters */

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //* HASHCODE AND EQUAL METHODS */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

