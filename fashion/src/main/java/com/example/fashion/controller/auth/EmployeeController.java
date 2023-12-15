package com.example.fashion.controller.auth;

import com.example.fashion.model.auth.Employee;
import com.example.fashion.model.auth.MyUserDetail;
import com.example.fashion.service.auth.IEmployeeService;
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

    /**
     * Retrieves employee information by account ID.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param id The ID of the account.
     * @return ResponseEntity containing the employee information or error message.
     */
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
