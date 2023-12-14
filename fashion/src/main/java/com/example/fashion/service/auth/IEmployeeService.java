package com.example.fashion.service.auth;

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
}
