package com.v2g.webservice.dto.analysis.analysis;

import java.io.Serializable;

import com.v2g.webservice.domain.analysis.analysis.Analysis;

import lombok.Getter;

@Getter
public class AnalysisMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String vflag;
    private int vpcost;
    private int vpelectric;
    private int vcost;
    private int velectric;
    

    public AnalysisMainResponseDto(Analysis entity) {
    	vflag = entity.getVflag();
    	vpcost = entity.getVpcost();
    	vpelectric = entity.getVpelectric();
    	vcost = entity.getVcost();
    	velectric = entity.getVelectric();
    }
    
}