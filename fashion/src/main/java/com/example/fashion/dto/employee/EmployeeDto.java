package com.example.fashion.dto.employee;

import com.example.fashion.model.auth.Account;

public class EmployeeDto {
    private Long Id;
    private String employeeCode;
    private String name;
    private String birthday;
    private String phone;
    private String email;
    private String address;

    private Account account;

    public EmployeeDto() {
    }

    public EmployeeDto(String employeeCode, String name, String birthday, String phone, String email, String address, Account account) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
