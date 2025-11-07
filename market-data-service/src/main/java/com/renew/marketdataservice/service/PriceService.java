package com.renew.marketdataservice.service;


import com.renew.marketdataservice.dto.priceDTOs.PriceRequestDTO;
import com.renew.marketdataservice.dto.priceDTOs.PriceResponseDTO;
import com.renew.marketdataservice.exception.ProductNotFound;
import com.renew.marketdataservice.mapper.PriceMapper;
import com.renew.marketdataservice.model.Prices;
import com.renew.marketdataservice.repo.PriceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PriceService {
    public PriceRepo priceRepo;
    public PriceService(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
    }
    public List<PriceResponseDTO> getPrices(){
        List<Prices>  prices = priceRepo.findAll();
        return prices.stream().map(PriceMapper::toDTO).toList();
    }

    public PriceResponseDTO createPrice(PriceRequestDTO priceRequestDTO){
        Prices newPrice = priceRepo.save(PriceMapper.toModel(priceRequestDTO));
        return PriceMapper.toDTO(newPrice);
    }

    public PriceResponseDTO updatePrice( UUID prodId,PriceRequestDTO priceRequestDTO){
        Prices newPrice = priceRepo.findById(prodId).orElseThrow(
    ()-> new ProductNotFound("product not found" +prodId));
        newPrice.setProdName(priceRequestDTO.getProdName());
        newPrice.setPrice(priceRequestDTO.getPrice());
        newPrice.setMarketName(priceRequestDTO.getMarketName());
        newPrice.setDistrict(priceRequestDTO.getDistrict());
        newPrice.setRegion(priceRequestDTO.getRegion());
        newPrice.setQuantity(priceRequestDTO.getQuantity());
        newPrice.setCreatedDate(priceRequestDTO.getCreatedDate());

        return PriceMapper.toDTO(priceRepo.save(newPrice));
    }
    public void deletePrice(UUID prodId){
        priceRepo.deleteById(prodId);
    }
}
