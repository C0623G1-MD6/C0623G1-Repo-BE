package com.example.fashion.service.customerService;

import com.example.fashion.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    Optional<Customer> findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);
}
