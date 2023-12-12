package com.example.fashion.service.customerService;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.customer.CustomerType;

import java.util.List;
import java.util.Optional;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(Integer id);

    void save(CustomerType customerType);

    void remove(Integer id);

}
