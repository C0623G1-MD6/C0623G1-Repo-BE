package com.example.fashion.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productCode;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String productImage;
    @Column(columnDefinition = "LONGTEXT")
    private String qrCode;
    private Boolean gender;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<SizeDetail> sizeDetails;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    public Product() {
    }

    public Product(Integer id, String productCode, String name, String productImage, String qrCode, Boolean gender,
                   Double price, ProductCategory category, List<SizeDetail> sizeDetails, Promotion promotion) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.productImage = productImage;
        this.qrCode = qrCode;
        this.gender = gender;
        this.price = price;
        this.category = category;
        this.sizeDetails = sizeDetails;
        this.promotion = promotion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public List<SizeDetail> getSizeDetails() {
        return sizeDetails;
    }

    public void setSizeDetails(List<SizeDetail> sizeDetails) {
        this.sizeDetails = sizeDetails;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
