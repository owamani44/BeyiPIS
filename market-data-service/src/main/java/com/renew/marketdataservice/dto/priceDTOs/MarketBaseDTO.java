package com.renew.marketdataservice.dto.priceDTOs;

import jakarta.validation.constraints.NotNull;

public abstract class MarketBaseDTO {
    @NotNull
    private String marketName;

    @NotNull
    private String district;

    @NotNull
    private String region;

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
