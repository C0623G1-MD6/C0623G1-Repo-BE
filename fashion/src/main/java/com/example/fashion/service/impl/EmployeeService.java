package com.example.fashion.service.impl;

import com.example.fashion.model.Employee;
import com.example.fashion.repository.IEmployeeRepository;
import com.example.fashion.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Employee getEmployeeByAccountId(Long id) {
        return employeeRepository.getEmployeeByAccountId(id);
    }
}
