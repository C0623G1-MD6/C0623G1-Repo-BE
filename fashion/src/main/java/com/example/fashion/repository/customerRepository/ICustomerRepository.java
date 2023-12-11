package com.example.fashion.repository.customerRepository;

import com.example.fashion.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
