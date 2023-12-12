package com.example.fashion.repository;


import com.example.fashion.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class IEmployeeRepository extends class JpaRepository.
 * @author: ThanhPV
 * @date: 12/12/2023
 */
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

    /**
     * Get information Employee
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param id to find by idAccount
     * @return Employee
     */
    Employee getEmployeeByAccountId (Long id);
}
