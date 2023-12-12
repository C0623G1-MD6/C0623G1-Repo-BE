package com.example.fashion.model.loanttv;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sizes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "sizes")
    private List<SizeDetails> sizeDetails;

    public Sizes() {
    }

    public Sizes(Integer id, String name, List<SizeDetails> sizeDetails) {
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

    public List<SizeDetails> getSizeDetails() {
        return sizeDetails;
    }

    public void setSizeDetails(List<SizeDetails> sizeDetails) {
        this.sizeDetails = sizeDetails;
    }
}
