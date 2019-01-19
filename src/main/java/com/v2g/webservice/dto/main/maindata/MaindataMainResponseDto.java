package com.v2g.webservice.dto.main.maindata;

import java.io.Serializable;

import com.v2g.webservice.domain.main.maindata.Maindata;

import lombok.Getter;

@Getter
public class MaindataMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String location;
    private int vcar;
    private int vcost;
    private int velectric;
    private int vaccure;
    private String dayflag;
    private int carcnt;

    public MaindataMainResponseDto(Maindata entity) {
        id = entity.getId();
        location = entity.getLocation();
        vcar = entity.getVcar();
        vcost = entity.getVcost();
        velectric = entity.getVelectric();
        vaccure = entity.getVaccure();
        dayflag = entity.getDayflag();
        carcnt = entity.getCarcnt();
    }
    
}