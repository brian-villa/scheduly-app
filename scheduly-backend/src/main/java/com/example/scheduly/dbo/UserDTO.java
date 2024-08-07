package com.example.scheduly.dbo;
import com.example.scheduly.entity.UserEntity;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class UserDTO {
    private UUID id;
    private String name;
    private String photo;
    private String email;
    private String phone;
    private String login;
    private String pwd;

    public UserDTO(UserEntity user) {
        BeanUtils.copyProperties(user, this);
    }

    public UserDTO () {

    }

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
}
