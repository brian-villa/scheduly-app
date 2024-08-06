package com.example.scheduly.entity;

import com.example.scheduly.dbo.UserDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "t_USER")
public class UserEntity {
    /* Class Atributes */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID _id;

    @Column (nullable = false)
    private String _name;

    @Column (nullable = false)
    private String _photo;

    @Column (nullable = false)
    private String _email;

    @Column (nullable = false)
    private String _phone;

    @Column (nullable = false, unique = true)
    private String _login;

    @Column (nullable = false)
    private String _pwd;

    public UserEntity(UserDTO user) {
        BeanUtils.copyProperties(user, this);
    }

    public UserEntity () {

    }

    /* Getter and Setters */

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_photo() {
        return _photo;
    }

    public void set_photo(String _photo) {
        this._photo = _photo;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public String get_login() {
        return _login;
    }

    public void set_login(String _login) {
        this._login = _login;
    }

    public String get_pwd() {
        return _pwd;
    }

    public void set_pwd(String _pwd) {
        this._pwd = _pwd;
    }


    //* HASHCODE AND EQUAL METHODS */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(_id, that._id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_id);
    }
}

