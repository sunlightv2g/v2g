package com.v2g.webservice.domain.trade.trade;

import java.util.List;

import com.v2g.webservice.dto.trade.trade.TradeResponseDto;
import com.v2g.webservice.dto.trade.trade.TradeSearchRequestDto;

public interface TradeCustom {
    List<TradeResponseDto> getTradeList(TradeSearchRequestDto tradeSearchRequestDto);
}