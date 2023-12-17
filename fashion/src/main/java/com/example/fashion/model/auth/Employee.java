package com.example.fashion.model.auth;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String employeeCode;
    private String name;
    private String birthday;
    private String phone;
    private String email;
    private String address;
    @OneToOne
    @JsonBackReference
    private Account account;
}
