package com.example.fashion.service.customerService;

import com.example.fashion.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll(String name, String typeCustomer);

    Optional<Customer> findById(Integer id);

    void save(Customer customer);

    void remove(int id);
}
