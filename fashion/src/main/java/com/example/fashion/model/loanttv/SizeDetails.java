package com.example.fashion.model.loanttv;
import jakarta.persistence.*;


@Entity
public class SizeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;
    @ManyToOne
    @JoinColumn(name = "size_id")
    private Sizes sizes;
    @Column(columnDefinition = "int default 0")
    private Integer quantity;

    public SizeDetails() {
    }

    public SizeDetails(Integer id, Products products, Sizes sizes, Integer quantity) {
        this.id = id;
        this.products = products;
        this.sizes = sizes;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
