package com.renew.marketdataservice.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="\"markets_db\"")
public class Market extends MarketSuperClass {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID marketID;


    public UUID getMarketID() {
        return marketID;
    }

    public void setMarketID(UUID marketID) {
        this.marketID = marketID;
    }
}
