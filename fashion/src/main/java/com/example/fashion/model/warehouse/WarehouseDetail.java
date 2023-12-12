package com.example.fashion.model.warehouse;


import com.example.fashion.model.product.Product;
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
    @JoinColumn(name = "product_id",columnDefinition = "id")
    private Product productId;
    @ManyToOne
    @JoinColumn(name = "warehouse_receipt_id",columnDefinition = "id")
    private Warehouse warehouseId;

    public WarehouseDetail() {
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

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Warehouse getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Warehouse warehouseId) {
        this.warehouseId = warehouseId;
    }
}
