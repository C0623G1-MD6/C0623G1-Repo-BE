package com.example.fashion.model.warehouse;

import com.example.fashion.model.product.Product;
import com.example.fashion.model.product.SizeDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * @author: LamTV
 * @date: 12/12/2023
 */
@Entity
@Table(name = "warehouse_receipt_details")
public class WarehouseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "double",nullable = false,name = "input_price")
    private Double inputPrice;
    @Column(columnDefinition = "int",nullable = false,name = "input_quantity")
    private Integer inputQuantity;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "size_detail_id",referencedColumnName = "id")
    private SizeDetail sizeDetail;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "warehouse_receipt_id",referencedColumnName = "id")
    private Warehouse warehouse;

    public WarehouseDetail() {
    }

    public WarehouseDetail(Double inputPrice, Integer inputQuantity, SizeDetail sizeDetail, Warehouse warehouse) {
        this.inputPrice = inputPrice;
        this.inputQuantity = inputQuantity;
        this.sizeDetail = sizeDetail;
        this.warehouse = warehouse;
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

    public SizeDetail getSizeDetail() {
        return sizeDetail;
    }

    public void setSizeDetail(SizeDetail sizeDetail) {
        this.sizeDetail = sizeDetail;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
