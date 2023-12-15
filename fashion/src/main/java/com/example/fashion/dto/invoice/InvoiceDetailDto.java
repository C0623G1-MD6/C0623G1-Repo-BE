package com.example.fashion.dto.invoice;

import com.example.fashion.model.invoice.Invoice;
import com.example.fashion.model.product.Product;

public class InvoiceDetailDto {
    private Integer id;

    private Integer sellingQuantity;

    private Invoice invoice;

    private Product product;

    public InvoiceDetailDto() {
    }

    public InvoiceDetailDto(Integer id, Integer sellingQuantity, Invoice invoice, Product product) {
        this.id = id;
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
