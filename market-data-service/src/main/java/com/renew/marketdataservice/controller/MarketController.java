package com.renew.marketdataservice.controller;



import com.renew.marketdataservice.dto.marketDTOs.MarketRequestDTO;
import com.renew.marketdataservice.dto.marketDTOs.MarketResponseDTO;
import com.renew.marketdataservice.service.MarketService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
        @RequestMapping("/markets")
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService=marketService;
    }

    @GetMapping
    public ResponseEntity<List<MarketResponseDTO>> getAllMarkets() {
        List<MarketResponseDTO> markets = marketService.getMarkets();
        return ResponseEntity.ok().body(markets);
    }

    @PostMapping
    public ResponseEntity<List<MarketResponseDTO>> createMarket(@Valid @RequestBody List<MarketRequestDTO> marketRequestDTO){
        List<MarketResponseDTO> marketResponseDTO = marketService.createMarket(marketRequestDTO);
        return ResponseEntity.ok().body(marketResponseDTO);
    }

    @PutMapping("/{marketID}")
    public ResponseEntity<MarketResponseDTO> updateMarket(@PathVariable UUID marketID,
                                                          @Validated({Default.class})
                                                          @RequestBody MarketRequestDTO marketRequestDTO ){
        MarketResponseDTO marketResponseDTO = marketService.updateMarket(marketID,marketRequestDTO);
        return ResponseEntity.ok().body(marketResponseDTO);
    }

    @DeleteMapping("/{marketID}")
    public ResponseEntity<MarketResponseDTO> deleteMarket(@PathVariable UUID marketID){
       marketService.deleteMarket(marketID);
       return ResponseEntity.noContent().build();
    }
}
