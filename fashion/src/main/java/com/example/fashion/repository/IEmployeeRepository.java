package com.example.fashion.repository;


import com.example.fashion.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Employee getEmployeeByAccountId (Long id);
}
