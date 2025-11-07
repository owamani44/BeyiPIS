package com.renew.marketdataservice.mapper;



import com.renew.marketdataservice.dto.marketDTOs.MarketRequestDTO;
import com.renew.marketdataservice.dto.marketDTOs.MarketResponseDTO;
import com.renew.marketdataservice.model.Market;

public class MarketMapper {

    public static MarketResponseDTO toDTO (Market market){
        MarketResponseDTO marketDTO = new MarketResponseDTO();
        marketDTO.setMarketId(market.getMarketID());
        marketDTO.setMarketName(market.getMarketName());
        marketDTO.setDistrict(market.getDistrict());
        marketDTO.setRegion(market.getRegion());

        return marketDTO;
    }

    public static Market toModel(MarketRequestDTO marketRequestDTO){
        Market market = new Market();
        market.setMarketName(marketRequestDTO.getMarketName());
        market.setDistrict(marketRequestDTO.getDistrict());
        market.setRegion(marketRequestDTO.getRegion());

        return market;
    }
}
