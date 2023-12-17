package com.example.fashion.dto.product;

import com.example.fashion.model.product.Product;
import com.example.fashion.model.product.Size;

public class SizeDetailDto {
    private Integer id;
    private Product product;
    private Size size;
    private Integer quantity;

    public SizeDetailDto() {
    }

    public SizeDetailDto(Product product, Size size, Integer quantity) {
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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
