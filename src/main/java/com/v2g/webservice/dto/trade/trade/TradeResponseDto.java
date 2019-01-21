package com.v2g.webservice.dto.trade.trade;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String vtime;
    private String vlocation;
    private String vflag;
    private String vcost;
    private String velectric;

}