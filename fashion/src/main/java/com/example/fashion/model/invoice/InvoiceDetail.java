package com.example.fashion.model.invoice;

import com.example.fashion.model.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "selling_quantity", nullable = false)
    private Integer sellingQuantity;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Integer sellingQuantity, Invoice invoice, Product product) {
        this.sellingQuantity = sellingQuantity;
        this.invoice = invoice;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellingQuantity() {
        return sellingQuantity;
    }

    public void setSellingQuantity(Integer sellingQuantity) {
        this.sellingQuantity = sellingQuantity;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
