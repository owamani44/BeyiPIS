package com.renew.marketdataservice.mapper;


import com.renew.marketdataservice.dto.priceDTOs.PriceRequestDTO;
import com.renew.marketdataservice.dto.priceDTOs.PriceResponseDTO;
import com.renew.marketdataservice.model.Prices;

public class PriceMapper {
    public static PriceResponseDTO toDTO(Prices prices) {
        PriceResponseDTO priceDTO = new PriceResponseDTO();
        priceDTO.setProdID(prices.getProdID().toString());
        priceDTO.setProdName(prices.getProdName());
        priceDTO.setPrice(prices.getPrice());
        priceDTO.setMarketName(prices.getMarketName());
        priceDTO.setDistrict(prices.getDistrict());
        priceDTO.setRegion(prices.getRegion());
        priceDTO.setCreatedDate(prices.getCreatedDate().toLocalDate());
        priceDTO.setQuantity(prices.getQuantity());

        return priceDTO;
    }

    public static Prices toModel(PriceRequestDTO priceRequestDTO){
        Prices prices = new Prices();
        prices.setProdName(priceRequestDTO.getProdName());
        prices.setPrice(priceRequestDTO.getPrice());
        prices.setMarketName(priceRequestDTO.getMarketName());
        prices.setDistrict(priceRequestDTO.getDistrict());
        prices.setRegion(priceRequestDTO.getRegion());
        prices.setCreatedDate(priceRequestDTO.getCreatedDate());
        prices.setQuantity(priceRequestDTO.getQuantity());

        return prices;
    }
}
