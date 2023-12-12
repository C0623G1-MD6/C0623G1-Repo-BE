package com.example.fashion.model.loanttv;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Products> productsList;

    public ProductCategories() {
    }

    public ProductCategories(Integer id, String name, List<Products> productsList) {
        this.id = id;
        this.name = name;
        this.productsList = productsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
