package com.v2g.webservice.dto.reservation.reservation;

import java.io.Serializable;

import com.v2g.webservice.domain.reservation.reservation.Reservation;

import lombok.Getter;

@Getter
public class ReservationMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String userid;
    private String place;
    private String rdate;
    private String rtime;
    private String rflag;
    private String rcost;
    private String relectirc;
    private String rleft;

    public ReservationMainResponseDto(Reservation entity) {
        id = entity.getId();
        userid = entity.getUserid();
        place = entity.getPlace();
        rdate = entity.getRdate();
        rtime = entity.getRtime();
        rflag = entity.getRflag();
        rcost = entity.getRcost();
        relectirc = entity.getRelectirc();
        rleft = entity.getRleft();
    }
    
}