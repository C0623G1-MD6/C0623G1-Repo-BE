package com.example.fashion.model.lamtv;

import com.example.fashion.model.loanttv.Products;
import jakarta.persistence.*;

/**
 * author: LamTV
 * date: 12/12/2023
 */
@Entity
@Table(name = "warehouse_receipt_details")
public class WarehouseReceiptDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "double",nullable = false,name = "input_price")
    private Double inputPrice;
    @Column(columnDefinition = "int",nullable = false,name = "input_quantity")
    private Integer inputQuantity;
    @ManyToOne
    @JoinColumn(name = "product_id",columnDefinition = "id")
    private Products products;
    @ManyToOne
    @JoinColumn(name = "warehouse_receipt_id",columnDefinition = "id")
    private WarehouseReceipt warehouseReceipt;

    public WarehouseReceiptDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(Double inputPrice) {
        this.inputPrice = inputPrice;
    }

    public Integer getInputQuantity() {
        return inputQuantity;
    }

    public void setInputQuantity(Integer inputQuantity) {
        this.inputQuantity = inputQuantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public WarehouseReceipt getWarehouseReceipt() {
        return warehouseReceipt;
    }

    public void setWarehouseReceipt(WarehouseReceipt warehouseReceipt) {
        this.warehouseReceipt = warehouseReceipt;
    }
}
