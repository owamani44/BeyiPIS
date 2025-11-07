package com.renew.marketdataservice.repo;


import com.renew.marketdataservice.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepo extends JpaRepository<Prices,UUID> {

}
