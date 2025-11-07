package com.renew.marketdataservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "prices_db")
public class Prices extends MarketSuperClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID prodID;

    @NotNull
    @Column(name="prodname")
    private String prodName;

    @NotNull
    private Double price;

    @NotNull
    private String quantity;

    @CreatedDate
    @Column(name = "createddate")
    private LocalDateTime createdDate;

    public UUID getProdID() {
        return prodID;
    }

    public void setProdID(UUID prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

