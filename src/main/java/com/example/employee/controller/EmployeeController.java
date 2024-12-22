package com.example.employee.controller;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Employee> updateEmployee(
            @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(employeeDetails);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Employee> getEmployee( @PathVariable long id ){
        Employee retrivedEmployee = employeeService.getEmployee(id);
        return new ResponseEntity<>(retrivedEmployee, HttpStatus.OK);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteEmployee( @PathVariable long id ){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("deleted succesfully", HttpStatus.BAD_REQUEST  );
    }
}
