package com.example.fashion.model.product;
import jakarta.persistence.*;

@Entity
@Table (name = "size_details")
public class SizeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;
    @Column(columnDefinition = "int default 0")
    private Integer quantity;

    public SizeDetail() {
    }

    public SizeDetail(Integer id, Product product, Size size, Integer quantity) {
        this.id = id;
        this.product = product;
        this.size = size;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSizes() {
        return size;
    }

    public void setSizes(Size size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
