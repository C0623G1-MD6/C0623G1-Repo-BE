package com.example.fashion.model.warehouse;

import jakarta.persistence.*;

import java.util.Set;

/**
 * @author: LamTV
 * @date: 12/12/2023
 */
@Entity
@Table(name = "warehouse_receipts")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(45)",nullable = false,name = "receipt_code")
    private String receiptCode;
    @Column(columnDefinition = "datetime",nullable = false,name = "receipt_date")
    private String receiptDate;
    @OneToMany(mappedBy = "warehouse")
    private Set<WarehouseDetail> warehouseDetailSet;
    public Warehouse() {
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

    public Set<WarehouseDetail> getWarehouseDetailSet() {
        return warehouseDetailSet;
    }

    public void setWarehouseDetailSet(Set<WarehouseDetail> warehouseDetailSet) {
        this.warehouseDetailSet = warehouseDetailSet;
    }
}
