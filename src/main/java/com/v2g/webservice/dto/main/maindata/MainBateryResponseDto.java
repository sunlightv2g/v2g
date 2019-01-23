package com.v2g.webservice.dto.main.maindata;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainBateryResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String building;
    private String flag;
    private String vdata;

}