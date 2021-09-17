package com.example.assignment.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String prodName;
    private Integer cartonSize;
    private Double cartonPrice;

    public Product() {
    }

    public Product(String prodName, Integer cartonSize, Double cartonPrice) {
        this.prodName = prodName;
        this.cartonSize = cartonSize;
        this.cartonPrice = cartonPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getCartonSize() {
        return cartonSize;
    }

    public void setCartonSize(Integer cartonSize) {
        this.cartonSize = cartonSize;
    }

    public Double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(Double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", prodName='" + prodName + '\'' +
                ", cartonSize=" + cartonSize +
                ", cartonPrice=" + cartonPrice +
                '}';
    }
}
