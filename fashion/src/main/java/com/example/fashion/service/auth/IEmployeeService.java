package com.example.fashion.service.auth;

import com.example.fashion.dto.employee.EmployeeDto;
import com.example.fashion.model.auth.Employee;

public interface IEmployeeService {
    /**
     * Retrieves an employee by account ID.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param id The account ID.
     * @return The employee associated with the account ID.
     */
    Employee getEmployeeByAccountId (Long id);
    void updateEmployee(Long accountId,EmployeeDto employeeDto);

    Long getEmployeeIdByUsername(String username);
}
