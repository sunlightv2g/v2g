package com.v2g.webservice.dto.customer.customer;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerMainCenterDataResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String vcar;
    private String vcost;
    private String velectric;
    private String vaccure;
    private String carcnt;

}