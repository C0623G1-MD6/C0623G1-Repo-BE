package com.example.fashion.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double percent;
    @JsonIgnore
    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private List<Product> productList;

    public Promotion() {
    }

    public Promotion(Integer id, Double percent, List<Product> productList) {
        this.id = id;
        this.percent = percent;
        this.productList = productList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
