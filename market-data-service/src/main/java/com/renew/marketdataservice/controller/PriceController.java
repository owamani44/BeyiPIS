package com.renew.marketdataservice.controller;


import com.renew.marketdataservice.dto.priceDTOs.PriceRequestDTO;
import com.renew.marketdataservice.dto.priceDTOs.PriceResponseDTO;
import com.renew.marketdataservice.service.PriceService;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prices")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<List<PriceResponseDTO>> getAllPrices(){
        List<PriceResponseDTO> priceResponseDTOS= priceService.getPrices();
        return ResponseEntity.ok().body(priceResponseDTOS);
    }

    @PostMapping
    public ResponseEntity<PriceResponseDTO> createPrice(@RequestBody PriceRequestDTO priceRequestDTO){
        PriceResponseDTO priceResponseDTO= priceService.createPrice(priceRequestDTO);
        return ResponseEntity.ok().body(priceResponseDTO);
    }

    @PutMapping("/{prodID}")
    public ResponseEntity<PriceResponseDTO> updatePrice(@PathVariable UUID prodID,
                                                        @Validated({Default.class})
                                                        @RequestBody PriceRequestDTO priceRequestDTO){
        PriceResponseDTO priceResponseDTO = priceService.updatePrice(prodID, priceRequestDTO);
        return ResponseEntity.ok().body(priceResponseDTO);
    }

    @DeleteMapping("/{prodID}")
    public ResponseEntity<PriceResponseDTO> deletePrice(@PathVariable UUID prodID){
        priceService.deletePrice(prodID);
        return ResponseEntity.noContent().build();
    }
}
