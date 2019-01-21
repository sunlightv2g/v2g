package com.v2g.webservice.dto.trade.trade;

import java.io.Serializable;

import com.v2g.webservice.domain.main.maindata.Maindata;
import com.v2g.webservice.domain.trade.trade.Trade;

import lombok.Getter;

@Getter
public class TradeMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String vtime;
    private String vlocation;
    private String vflag;
    private int vcost;
    private int velectric;
    

    public TradeMainResponseDto(Trade entity) {
    	vtime = entity.getVtime();
    	vlocation = entity.getVlocation();
    	vflag = entity.getVflag();
    	vcost = entity.getVcost();
    	velectric = entity.getVelectric();
    }
    
}