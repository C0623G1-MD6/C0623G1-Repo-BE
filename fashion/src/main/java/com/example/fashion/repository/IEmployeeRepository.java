package com.example.fashion.repository;


import com.example.fashion.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query(value = "SELECT * FROM employees as e WHERE e.account_id = :id", nativeQuery = true)
    Employee getEmployeeByAccountId(@Param("id") Long id);
}
