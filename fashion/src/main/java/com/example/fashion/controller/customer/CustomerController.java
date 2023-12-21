package com.example.fashion.controller.customer;

import com.example.fashion.dto.customerDto.CustomerDto;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.customer.CustomerType;
import com.example.fashion.service.customerService.ICustomerService;
import com.example.fashion.service.customerService.ICustomerTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    @PostMapping("")
    public ResponseEntity<?> createNewCustomer(@RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        Customer customer = new Customer();
        Map<String, String> customerDtoMap = new HashMap<>();
        new CustomerDto().validate(customerDto, bindingResult);
        Customer customerCheckEmail = customerService.findCustomerByEmail(customerDto.getEmail());
        if (customerCheckEmail != null) {
            customerDtoMap.put("email", "email đã được sử dụng ");
        }
        Customer customerCheckCode = customerService.findCustomerByCode(customerDto.getCustomerCode());
        if (customerCheckCode != null) {
            customerDtoMap.put("customerCode", "code đã được đăng kí ");
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
            return new ResponseEntity<>(customerDtoMap, HttpStatus.CREATED);
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
    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> editCustomer(@Valid @RequestBody CustomerDto customerDto, @PathVariable Integer id, BindingResult bindingResult) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Map<String, String> customerDtoMap = new HashMap<>();
        new CustomerDto().validate(customerDto, bindingResult);
        if (!customer.getEmail().equals(customerDto.getEmail())) {
            Customer customerCheckEmail = customerService.findCustomerByEmail(customerDto.getEmail());
            if (customerCheckEmail != null) {
                customerDtoMap.put("email", "email đã được đăng ki");
            }
        }
        if (!customer.getPhone().equals(customerDto.getPhone())) {
            Customer customerCheckPhone = customerService.findCustomerByPhone(customerDto.getPhone());
            if (customerCheckPhone != null) {
                customerDtoMap.put("phone", "Số điện thoại đã được đăng ki");
            }
        }
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                customerDtoMap.put(err.getField(), err.getDefaultMessage());
            }
        }
        if (customerDtoMap.size() != 0) {
            return new ResponseEntity<>(customerDtoMap, HttpStatus.CREATED);
        }
        CustomerType customerType = customerTypeService.findById(customerDto.getCustomerTypeId());
        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerType);
        customer.setId(id);
        customerService.editCustomerRepo(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * method getAllCustomer
     * create by TrungND
     * date 12-12-2023
     * param :
     * return ResponseEntity and customer or null
     */
    @GetMapping("/list")
    public ResponseEntity<?> getAll(
            @RequestParam(name = "nameCustomer", defaultValue = "") String name,
            @RequestParam(name = "typeCustomer", defaultValue = "") String typeCustomer,
            @RequestParam(defaultValue = "0", required = false) int page

    ) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Customer> customerDtos = customerService.findAllCustomer(pageable, name, typeCustomer);
        if (customerDtos == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (customerDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerDtos, HttpStatus.OK);
        }
    }


    /**
     * method deleteCustomer
     * create by TrungND
     * date 12-12-2023
     * param : id
     * return ResponseEntity or null
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
