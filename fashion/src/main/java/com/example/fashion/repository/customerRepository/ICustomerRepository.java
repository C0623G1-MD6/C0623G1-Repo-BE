package com.example.fashion.repository.customerRepository;

import com.example.fashion.model.customer.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update customers set name = :#{#customer.name}, gender = :#{#customer.gender}, " +
            " birthday = :#{#customer.birthday}, point = :#{#customer.point}, " +
            " address = :#{#customer.address}, email = :#{#customer.email}, phone = :#{#customer.phone} " +
            "WHERE id = :#{#customer.id} ", nativeQuery = true)
    void editCustomerRepo(@Param("customer") Customer customer);

    @Transactional
    @Modifying
    @Query(value = "insert into customers (customer_code, name, gender, birthday, point, address, email, phone) " +
            "value ( :#{#customer.customerCode}, :#{#customer.name}, :#{#customer.gender}, :#{#customer.birthday}, " +
            ":#{#customer.point},  :#{#customer.address}, :#{#customer.email}, :#{#customer.phone}) "
            , nativeQuery = true)
    void createCustomerRepo(@Param("customer") Customer customer);

    @Query(value = "select customers.id, customers.name,customers.customer_code,customers.gender,customers.birthday, customers.phone, " +
            "customers.email, customers.point, customers.address, customers.customer_type_id, customers.is_deleted " +
            "from customers" +
            " join customer_type on customers.customer_type_id = customer_type.id" +
            " where " +
            " customers.is_deleted = '0' " +
            " and customers.name like :name and customer_type.name like :typeCustomer", nativeQuery = true)
    List<Customer> findAllCustomer(@Param("name") String name, @Param("typeCustomer") String typeCustomer);

    @Modifying
    @Transactional
    @Query(value = " update customers set customers.is_deleted = 1 where customers.id = :id", nativeQuery = true)
    void deleteId(@Param("id") int id);


    @Query(value = "select * from customers where phone = :phone ",nativeQuery = true)
    Customer findCustomerByPhone(@Param("phone") String phone);

    @Query(value = "select * from customers where email = :email ",nativeQuery = true)
    Customer findCustomerByEmail(@Param("email") String email);
}
