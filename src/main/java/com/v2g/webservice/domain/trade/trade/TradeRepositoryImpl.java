package com.v2g.webservice.domain.trade.trade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.v2g.webservice.dto.trade.trade.TradeResponseDto;
import com.v2g.webservice.dto.trade.trade.TradeSearchRequestDto;

@Repository
public class TradeRepositoryImpl extends QueryDslRepositorySupport implements TradeCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public TradeRepositoryImpl() {
        super(Trade.class);
    }
    
    @Override
    public List<TradeResponseDto> getTradeList(TradeSearchRequestDto tradeSearchRequestDto) {
    	
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
    	String query = "select "; 
				query += " vtime ";
				query += ",vlocation ";
				query += ",vflag ";
				query += ",round(vcost * 0.001,1) as vcost ";
				query += ",round(velectric * 0.001,1) as velectric ";
				query += "from ";
				query += " trade ";
			
    	System.out.println(query);
    	Query q = entityManager.createNativeQuery(query);
	    List<Object> result = (List<Object>) q.getResultList();
	    
	    List<TradeResponseDto> mainDataResponseDtoList = new ArrayList<TradeResponseDto>();
    	Iterator itr = result.iterator();
    	while(itr.hasNext()){
    		TradeResponseDto mainDataResponseDto = new TradeResponseDto();
    	   Object[] obj = (Object[]) itr.next();

    	   mainDataResponseDto.setVtime(String.valueOf(obj[0]));
    	   mainDataResponseDto.setVlocation(String.valueOf(obj[1]));
    	   mainDataResponseDto.setVflag(String.valueOf(obj[2]));
    	   mainDataResponseDto.setVcost(String.valueOf(obj[3]));
    	   mainDataResponseDto.setVelectric(String.valueOf(obj[4]));
    	   mainDataResponseDtoList.add(mainDataResponseDto);
    	}
   	
    	return mainDataResponseDtoList;
    	
    }
    
}