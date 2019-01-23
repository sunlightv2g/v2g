package com.v2g.webservice.dto.reservation.reservation;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String timeflag;
    private String vcost;
    private String vflag;
    private String velectric;

}