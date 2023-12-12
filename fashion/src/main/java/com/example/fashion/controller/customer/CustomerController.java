package com.example.fashion.controller.customer;

import com.example.fashion.dto.customerDto.CustomerDto;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.customer.CustomerType;
import com.example.fashion.service.customerService.ICustomerService;
import com.example.fashion.service.customerService.ICustomerTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    /**
     * method getCustomerById
     * create by ThienLCH
     * date 11-12-2023
     * param : id
     * return ResponseEntity and customer or null
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerService.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }


    /**
     * method createNewCustomer
     * create by ThienLCH
     * date 11-12-2023
     * param
     * return ResponseEntity or null
     */
    @PostMapping("/create")
    public ResponseEntity<?> createNewCustomer(@RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        Customer customer = new Customer();
        Map<String, String> customerDtoMap = new HashMap<>();
        new CustomerDto().validate(customerDto, bindingResult);
        Customer customerCheckEmail = customerService.findCustomerByEmail(customerDto.getEmail());
        if (customerCheckEmail != null) {
            customerDtoMap.put("email", "Email đã được đăng kí ");
        }
        Customer customerCheckPhone = customerService.findCustomerByPhone(customerDto.getPhone());
        if (customerCheckPhone != null) {
            customerDtoMap.put("phone", "Số điện thoại đã được đăng kí ");
        }
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                customerDtoMap.put(err.getField(), err.getDefaultMessage());
            }
        }
        if (customerDtoMap.size() != 0) {
            return new ResponseEntity<>(customerDtoMap, HttpStatus.NOT_ACCEPTABLE);
        }
        CustomerType customerType = customerTypeService.findById(1);
        BeanUtils.copyProperties(customerDto, customer);
        customer.setPoint(0);
        customer.setCustomerType(customerType);
        customerService.createCustomerRepo(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * method editCustomer
     * create by ThienLCH
     * date 11-12-2023
     * param : id
     * return ResponseEntity or null
     */
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> editCustomer(@PathVariable Integer id, @Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Map<String, String> customerDtoMap = new HashMap<>();
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                customerDtoMap.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CustomerType customerType = customerTypeService.findById(customerDto.getCustomerTypeId());
        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerType);
        customer.setId(id);
        customerService.editCustomerRepo(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
