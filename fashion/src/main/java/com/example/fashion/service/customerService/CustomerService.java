package com.example.fashion.service.customerService;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.repository.customerRepository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void editCustomerRepo(Customer customer) {
        customerRepository.editCustomerRepo(customer);
    }

    @Override
    public void createCustomerRepo(Customer customer) {
        customerRepository.createCustomerRepo(customer);
    }

    @Override
    public Customer findCustomerByPhone(String phone) {
        return customerRepository.findCustomerByPhone("%" + phone + "%");
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }
}