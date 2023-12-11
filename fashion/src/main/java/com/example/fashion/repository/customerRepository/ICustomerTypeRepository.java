package com.example.fashion.repository.customerRepository;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

}
