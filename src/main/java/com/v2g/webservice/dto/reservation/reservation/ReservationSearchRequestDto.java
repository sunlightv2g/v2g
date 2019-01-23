package com.v2g.webservice.dto.reservation.reservation;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationSearchRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
    
	private String userid;
    private String searchFlag;
    private String searchStr;

    
}