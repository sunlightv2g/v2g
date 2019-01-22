package com.v2g.webservice.dto.analysis.analysis;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnalysisResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String vflag;
    private String vpcost;
    private String vpelectric;
    private String vcost;
    private String velectric;
    private String dayflag;

}