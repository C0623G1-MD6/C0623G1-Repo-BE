package com.example.fashion.model.product;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "sizes")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "size")
    private List<SizeDetail> sizeDetails;

    public Size() {
    }

    public Size(Integer id, String name, List<SizeDetail> sizeDetails) {
        this.id = id;
        this.name = name;
        this.sizeDetails = sizeDetails;
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

    public List<SizeDetail> getSizeDetails() {
        return sizeDetails;
    }

    public void setSizeDetails(List<SizeDetail> sizeDetails) {
        this.sizeDetails = sizeDetails;
    }
}
