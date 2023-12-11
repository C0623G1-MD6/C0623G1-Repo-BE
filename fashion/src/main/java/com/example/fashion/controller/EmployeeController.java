package com.example.fashion.controller;

import com.example.fashion.model.Employee;
import com.example.fashion.model.MyUserDetail;
import com.example.fashion.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/employee")
@CrossOrigin("**")
@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getInfoEmployeeByIdAccount(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetail userDetail = (MyUserDetail) authentication.getPrincipal();
        if (userDetail.getAccount().getId() == id) {
            Employee employee = employeeService.getEmployeeByAccountId(id);
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        return new ResponseEntity<>("Bạn không có quyền truy cập vào tài nguyên này", HttpStatus.UNAUTHORIZED);
    }
}
