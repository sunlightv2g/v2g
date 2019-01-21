package com.v2g.webservice.dto.trade.trade;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeSearchRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
    
	private String location;
	private String dayflag;
	private String tablename;

    
}