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
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private Integer id;
    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;
    @Column(name = "discount_percent", columnDefinition = "int")
    private Integer discountPercent;
}
