package com.example.fashion.service.customerService;

import com.example.fashion.dto.customerDto.ICustomerDto;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.repository.customerRepository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll(String name, String typeCustomer) {
        return customerRepository.findAllCustomer("%" + name + "%", "%" + typeCustomer + "%");
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
    public void remove(int id) {
        customerRepository.deleteId(id);
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
































    /**
     * The method help to get page customer.
     * @author NhatNk
     * @since 2023-12-13
     * @param pageable
     * @param keyword is String entered from input box on the screen
     * @return Page ICustomerDto If the query at ICustomerRepository is correct and no exception occurs
     * @return Null If the query at ICustomerRepository is incorrect and an exception occurs
     * @see Page<ICustomerDto>
     */
    @Override
    public Page<ICustomerDto> getAllCustomer(Pageable pageable, String keyword) {
        try {
            return customerRepository.getAllCustomer(pageable, "%"+keyword+"%");
        } catch (Exception e){
            return null;
        }
    }

}
