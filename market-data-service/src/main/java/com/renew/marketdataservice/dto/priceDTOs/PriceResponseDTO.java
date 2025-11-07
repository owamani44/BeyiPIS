package com.renew.marketdataservice.dto.priceDTOs;


import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

public class PriceResponseDTO extends MarketBaseDTO {
    private String prodID;
    private String prodName;
    private Double price;
    private String quantity;
    @CreatedDate
    private LocalDate createdDate;


    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
