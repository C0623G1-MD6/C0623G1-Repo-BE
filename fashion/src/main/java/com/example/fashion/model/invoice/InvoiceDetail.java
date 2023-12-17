package com.example.fashion.model.invoice;

import com.example.fashion.model.product.SizeDetail;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "selling_quantity", nullable = false)
    private Integer sellingQuantity;

    @Column(name = "selling_price", nullable = false)
    private Double sellingPrice;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "size_detail_id", referencedColumnName = "id")
    private SizeDetail sizeDetail;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Integer sellingQuantity, Double sellingPrice, Invoice invoice, SizeDetail sizeDetail) {
        this.sellingQuantity = sellingQuantity;
        this.sellingPrice = sellingPrice;
        this.invoice = invoice;
        this.sizeDetail = sizeDetail;
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

    public SizeDetail getSizeDetail() {
        return sizeDetail;
    }

    public void setSizeDetail(SizeDetail sizeDetail) {
        this.sizeDetail = sizeDetail;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
