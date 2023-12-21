package com.example.fashion.service.customerService;

import com.example.fashion.dto.customerDto.ICustomerDto;
import com.example.fashion.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    /**
     * method: findAllCustomer
     * create by TrungND
     * date 12-12-2023
     * param : pageable,name,typeCustomer
     * return :
     */
    Page<Customer> findAllCustomer(Pageable pageable, String name, String typeCustomer);

    /**
     * method: remove
     * create by TrungND
     * date 12-12-2023
     * param : id
     * return :
     */
    void remove(int id);

    Customer findById(Integer id);

    void save(Customer customer);

    void editCustomerRepo(Customer customer);

    void createCustomerRepo(Customer customer);

    Customer findCustomerByPhone(String phone);

    Customer findCustomerByEmail(String email);

    Customer findCustomerByCode(String code);

    Page<ICustomerDto> getAllCustomer(Pageable pageable, String keyword);

    Boolean updatePoint(Integer point, Integer customerId);

    Boolean updateCustomerType(Integer point, Integer customerId);
}
