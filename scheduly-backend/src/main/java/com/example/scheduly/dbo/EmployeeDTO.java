package com.example.scheduly.dbo;

import com.example.scheduly.entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
public class EmployeeDTO {

    private UUID id;
    private String name;
    private Date birthDate;
    private String gender;
    private String email;
    private String phone;
    private String photo;
    private Boolean status;
    private String pwd;

    public EmployeeDTO() {}

    public EmployeeDTO(EmployeeEntity employee) {
        BeanUtils.copyProperties(employee, this);


    }

}
