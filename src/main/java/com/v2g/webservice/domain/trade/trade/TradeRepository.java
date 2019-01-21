package com.v2g.webservice.domain.trade.trade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long>, TradeCustom {

}