package com.example.scheduly.controller;

import com.example.scheduly.dbo.EmployeeDTO;
import com.example.scheduly.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> listAll() {
        return employeeService.listAllEmployees();
    }

    @PostMapping
    public void insertEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.insert(employeeDTO);
    }

    @PutMapping
    public EmployeeDTO changeEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.change(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") UUID id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
