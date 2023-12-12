package com.example.fashion.controller.customerController;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.service.customerService.ICustomerService;
import com.example.fashion.service.customerService.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class RestCustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAll(
            @RequestParam(name = "nameCustomer", defaultValue = "") String name,
            @RequestParam(name = "typeCustomer", defaultValue = "") String typeCustomer
    ) {
        List<Customer> customers = customerService.findAll(name, typeCustomer);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        customerService.remove(id);
        return ResponseEntity.ok("Xóa Thành Công");
    }
}
