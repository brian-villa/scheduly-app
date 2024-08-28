package com.example.scheduly.entity;

import com.example.scheduly.dbo.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name="t_employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date birthDate;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private String pwd;


    public EmployeeEntity() {}

    public EmployeeEntity(EmployeeDTO employee) {
        BeanUtils.copyProperties(employee, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
