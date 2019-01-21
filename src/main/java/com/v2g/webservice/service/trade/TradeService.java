package com.v2g.webservice.service.trade;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v2g.webservice.domain.trade.trade.TradeRepository;
import com.v2g.webservice.dto.trade.trade.TradeResponseDto;
import com.v2g.webservice.dto.trade.trade.TradeSearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TradeService {
	
    private TradeRepository tradeRepository;

    @Transactional(readOnly = true)
    public List<TradeResponseDto> getTradeList(TradeSearchRequestDto tradeSearchRequestDto) {
        return tradeRepository.getTradeList(tradeSearchRequestDto);
    }
    
}