package com.example.fashion.service.customerService;

import com.example.fashion.model.customer.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    void editCustomerRepo(Customer customer);

    void createCustomerRepo(Customer customer);
    Customer findCustomerByPhone(String phone);
    Customer findCustomerByEmail(String email);
}
