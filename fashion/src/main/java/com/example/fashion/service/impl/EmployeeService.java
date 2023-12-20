package com.example.fashion.service.impl;

import com.example.fashion.model.auth.Employee;
import com.example.fashion.repository.auth.IEmployeeRepository;
import com.example.fashion.service.auth.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * This method retrieves an employee by account ID.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param id The account ID.
     * @return The employee associated with the account ID.
     */
    @Override
    public Employee getEmployeeByAccountId(Long id) {
        return employeeRepository.getEmployeeByAccountId(id);
    }

    @Override
    public Long getEmployeeIdByUsername(String username) {
        try {
            return employeeRepository.getEmployeeIdByUsername(username);
        } catch (Exception e){
            return null;
        }
    }
}
