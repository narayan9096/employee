package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPosition(employeeDTO.getPosition());
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee( Employee employeeDetails) {
        Employee existingEmployee = employeeRepository.findById(employeeDetails.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeDetails.getId()));

        // Update fields
        existingEmployee.setName(employeeDetails.getName());
         existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setPosition(employeeDetails.getPosition());
        // Save updated employee to the database
        return employeeRepository.save(existingEmployee);
    }
    public Employee getEmployee(long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
               return existingEmployee;
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeeByPostion(String position) {
        List<Employee> employeeList = employeeRepository.findByPosition(position);
        return employeeList;
    }
}
