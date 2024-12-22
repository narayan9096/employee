package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
      @Query("SELECT e FROM Employee e WHERE e.position = :position")
      List<Employee> findEmployeesByPosition(@Param("position") String position);
}
