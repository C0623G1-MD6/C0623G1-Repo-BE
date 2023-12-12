package com.example.fashion.model.product;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> productsList;

    public ProductCategory() {
    }

    public ProductCategory(Integer id, String name, List<Product> productsList) {
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

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
