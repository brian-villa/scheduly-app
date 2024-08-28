package com.example.scheduly.service;

import com.example.scheduly.dbo.EmployeeDTO;
import com.example.scheduly.entity.EmployeeEntity;
import com.example.scheduly.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> listAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();

        return employees.stream().map(EmployeeDTO::new).toList();
    }

    public void insert(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity(employeeDTO);
        employeeRepository.save(employeeEntity);
    }

    public EmployeeDTO change(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity(employeeDTO);

        return new EmployeeDTO(employeeRepository.save(employeeEntity));
    }

    public void delete(UUID id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        employeeRepository.delete(employeeEntity);
    }

    public EmployeeDTO findById(UUID id) {
        return new EmployeeDTO(employeeRepository.findById(id).get());
    }


}
