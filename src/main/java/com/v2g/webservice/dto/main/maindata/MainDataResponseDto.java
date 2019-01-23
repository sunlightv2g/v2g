package com.v2g.webservice.dto.main.maindata;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainDataResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String vcar;
    private String vcost;
    private String velectric;
    private String vaccure;
    private String carcnt;
    private String location;
    private String dayflag;
    private String userid;
    private String vleft;
    private String vreservation;
    private String building;

}