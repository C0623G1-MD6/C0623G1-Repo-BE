package com.example.fashion.service.customerService;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.customer.CustomerType;
import com.example.fashion.repository.customerRepository.ICustomerRepository;
import com.example.fashion.repository.customerRepository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(Integer id) {
        customerTypeRepository.deleteById(id);
    }
}
