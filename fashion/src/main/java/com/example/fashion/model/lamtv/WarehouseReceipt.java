package com.example.fashion.model.lamtv;

import jakarta.persistence.*;

/**
 * author: LamTV
 * date: 12/12/2023
 */
@Entity
@Table(name = "warehouse_receipts")
public class WarehouseReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(45)",nullable = false,unique = true,name = "receipt_code")
    private String receiptCode;
    @Column(columnDefinition = "datetime",nullable = false,name = "receipt_date")
    private String receiptDate;
    @Column(columnDefinition = "double",nullable = false,name = "input_total_cost")
    private Double inputTotalCost;

    public WarehouseReceipt() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Double getInputTotalCost() {
        return inputTotalCost;
    }

    public void setInputTotalCost(Double inputTotalCost) {
        this.inputTotalCost = inputTotalCost;
    }
}
