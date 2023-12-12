package com.example.fashion.service.customerService;

import com.example.fashion.model.customer.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll(String name, String typeCustomer);

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(int id);

    void editCustomerRepo(Customer customer);

    void createCustomerRepo(Customer customer);
    Customer findCustomerByPhone(String phone);
    Customer findCustomerByEmail(String email);
}
