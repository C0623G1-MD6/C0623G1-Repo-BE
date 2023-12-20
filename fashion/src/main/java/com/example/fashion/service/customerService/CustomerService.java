package com.example.fashion.service.customerService;

import com.example.fashion.dto.customerDto.ICustomerDto;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.repository.customerRepository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    /**
     * method findAllCustomer
     * create by TrungND
     * date 12-12-2023
     * param : pageable,name,typeCustomer
     * return :customerRepository.findAllCustomer
     */
    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String name, String typeCustomer) {
        return customerRepository.findAllCustomer(pageable,"%" + name + "%", "%" + typeCustomer + "%");
    }

    /**
     * method remove
     * create by TrungND
     * date 12-12-2023
     * param : id
     * return :customerRepository.deleteId
     */
    @Override
    public void remove(int id) {
        customerRepository.deleteId(id);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
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
        return customerRepository.findCustomerByPhone(phone);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public Customer findCustomerByCode(String code) {
        return customerRepository.findCustomerByCode("%" + code + "%");
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

    @Override
    public Boolean updatePoint(Integer point, Integer customerId) {
        try {
            customerRepository.updatePoint(point,customerId);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateCustomerType(Integer point, Integer customerId) {
        Integer customerTypeId;
        if (point<=10000){
            customerTypeId = 1;
        }else if (point<=20000){
            customerTypeId = 2;
        } else if(point<=40000){
            customerTypeId = 3;
        } else {
            customerTypeId = 4;
        }

        try {
            customerRepository.updateCustomerType(customerTypeId, customerId);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
