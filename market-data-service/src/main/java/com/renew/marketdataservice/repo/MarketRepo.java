package com.renew.marketdataservice.repo;


import com.renew.marketdataservice.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MarketRepo extends JpaRepository<Market, UUID> {

}
