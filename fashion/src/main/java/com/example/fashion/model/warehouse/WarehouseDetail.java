package com.example.fashion.model.warehouse;
import com.example.fashion.model.product.SizeDetail;
import jakarta.persistence.*;


@Entity
@Table (name = "warehouse_receipt_details")
public class WarehouseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "size_detail_id",referencedColumnName = "id",nullable = false)
    private SizeDetail sizeDetail;
    @ManyToOne
    @JoinColumn(name = "warehouse_id",referencedColumnName = "id",nullable = false)
    private Warehouse warehouse;
    @Column(name="input_quantity",nullable = false)
    private Integer inputQuantity;

    @Column(name="input_price",nullable = false)
    private Double inputPrice;

    public WarehouseDetail() {
    }

    public WarehouseDetail(SizeDetail sizeDetail, Warehouse warehouse, Integer inputQuantity, Double inputPrice) {
        this.sizeDetail = sizeDetail;
        this.warehouse = warehouse;
        this.inputQuantity = inputQuantity;
        this.inputPrice = inputPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getInputQuantity() {
        return inputQuantity;
    }

    public void setInputQuantity(Integer quantity) {
        this.inputQuantity = quantity;
    }

    public Double getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(Double price) {
        this.inputPrice = price;
    }
}
