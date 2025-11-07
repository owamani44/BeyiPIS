package com.renew.marketdataservice.dto.marketDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MarketRequestDTO {

    @NotBlank
    @Size(max=70,message="Market Name must be included")
    private String marketName;

    @NotBlank
    @Size(message = "District must be included")
    private String district;

    @NotBlank
    @Size(message="Region must be included")
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
