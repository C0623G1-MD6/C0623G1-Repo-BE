package com.example.fashion.model.product;

import com.example.fashion.model.warehouse.WarehouseDetail;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "sizes")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Size() {
    }

    public Size(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
