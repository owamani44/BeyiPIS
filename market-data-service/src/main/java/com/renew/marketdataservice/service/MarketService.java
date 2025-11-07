package com.renew.marketdataservice.service;


import com.renew.marketdataservice.dto.marketDTOs.MarketRequestDTO;
import com.renew.marketdataservice.dto.marketDTOs.MarketResponseDTO;
import com.renew.marketdataservice.exception.MarketNotFound;
import com.renew.marketdataservice.mapper.MarketMapper;
import com.renew.marketdataservice.model.Market;
import com.renew.marketdataservice.repo.MarketRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MarketService {

    public MarketRepo marketRepo;

    public MarketMapper marketMapper;

    public MarketService(MarketRepo marketRepo) {
        this.marketRepo = marketRepo;
    }

    public List<MarketResponseDTO> getMarkets(){
        List<Market> markets = marketRepo.findAll();
        return markets.stream().map(MarketMapper::toDTO).toList();
    }

    public List<MarketResponseDTO> createMarket(List<MarketRequestDTO> marketRequestDTO){
        List<Market> markets = marketRequestDTO.stream().
                map(MarketMapper::toModel)
                .toList();

        List<Market> newMarkets = marketRepo.saveAll(markets);

        return newMarkets.stream().map(MarketMapper::toDTO).toList();

    }
    public MarketResponseDTO updateMarket(UUID marketID, MarketRequestDTO marketRequestDTO){
        Market market = marketRepo.findById(marketID).
            orElseThrow( ()-> new MarketNotFound("Market not found" + marketID));
        market.setMarketName(marketRequestDTO.getMarketName());
        market.setDistrict(marketRequestDTO.getDistrict());
        market.setRegion(marketRequestDTO.getRegion());

        Market updatedMarket = marketRepo.save(market);
        return MarketMapper.toDTO(updatedMarket);
    }

    public void deleteMarket(UUID marketID){
        marketRepo.deleteById(marketID);
    }

}
