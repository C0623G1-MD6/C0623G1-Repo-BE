package com.example.fashion.controller.customer;

import com.example.fashion.model.customer.CustomerType;
import com.example.fashion.service.customerService.ICustomerService;
import com.example.fashion.service.customerService.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customerType")
public class CustomerTypeController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    /**
     * method getCustomerTypeList
     * create by ThienLCH
     * date 11-12-2023
     * param: none
     * return ResponseEntity or null
     */
    @GetMapping("")
    public ResponseEntity<List<CustomerType>> getCustomerTypeList() {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        if (customerTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
