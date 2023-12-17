package com.example.fashion.model.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private Integer id;
    @Column(name = "customer_code", columnDefinition = "varchar(255)", unique = true)
    private String customerCode;
    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;
    @Column(name = "gender", columnDefinition = "bit(1) default 0")
    private boolean gender;
    @Column(name = "birthday", columnDefinition = "varchar(255)")
    private String birthday;
    @Column(name = "phone", columnDefinition = "varchar(255)")
    private String phone;
    @Column(name = "point", columnDefinition = "int")
    private Integer point;
    @Column(name = "email", columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "address", columnDefinition = "varchar(255)")
    private String address;
    @Column(name = "is_deleted", columnDefinition = "bit(1) default 0")
    private boolean isDeleted;
    @ManyToOne
    private CustomerType customerType;
}
