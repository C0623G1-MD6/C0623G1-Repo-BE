package com.example.fashion.repository.customerRepository;

import com.example.fashion.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * method editCustomerRepo
     * create by ThienLCH
     * date 11-12-2023
     * param : customer
     * return void
     */
    @Transactional
    @Modifying
    @Query(value = "update customers set name = :#{#customer.name}, gender = :#{#customer.gender}, " +
            " birthday = :#{#customer.birthday}, point = :#{#customer.point}, " +
            " address = :#{#customer.address}, email = :#{#customer.email}, phone = :#{#customer.phone} " +
            "WHERE id = :#{#customer.id} ", nativeQuery = true)
    void editCustomerRepo(@Param("customer") Customer customer);

    /**
     * method createCustomerRepo
     * create by ThienLCH
     * date 11-12-2023
     * param : customer
     * return void
     */
    @Transactional
    @Modifying
    @Query(value = "insert into customers (customer_code, name, gender, birthday, point, address, email, phone) " +
            "value ( :#{#customer.customerCode}, :#{#customer.name}, :#{#customer.gender}, :#{#customer.birthday}, " +
            ":#{#customer.point},  :#{#customer.address}, :#{#customer.email}, :#{#customer.phone}) "
            , nativeQuery = true)
    void createCustomerRepo(@Param("customer") Customer customer);

    /**
     * method findCustomerByPhone
     * create by ThienLCH
     * date 11-12-2023
     * param : phone
     * return Customer
     */
    @Query(value = "select * from customers where phone = :phone ",nativeQuery = true)
    Customer findCustomerByPhone(@Param("phone") String phone);

    /**
     * method findCustomerByEmail
     * create by ThienLCH
     * date 11-12-2023
     * param : email
     * return Customer
     */
    @Query(value = "select * from customers where email = :email ",nativeQuery = true)
    Customer findCustomerByEmail(@Param("email") String email);

    /**
     * method findCustomerByCode
     * create by ThienLCH
     * date 11-12-2023
     * param : code
     * return Customer
     */
    @Query(value = "select * from customers where customer_code = :code ",nativeQuery = true)
    Customer findCustomerByCode(@Param("code") String code);
}
