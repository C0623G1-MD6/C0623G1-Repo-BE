package com.example.fashion.repository.auth;


import com.example.fashion.model.auth.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Modifying
    @Query(value = "UPDATE employees SET name = :name, birthday = :birthday, phone = :phone, email = :email, address = :address WHERE account_id = :accountId", nativeQuery = true)
    void updateEmployee(@Param("accountId") Long accountId, @Param("name") String name, @Param("birthday") String birthday, @Param("phone") String phone, @Param("email") String email, @Param("address") String address);

}
