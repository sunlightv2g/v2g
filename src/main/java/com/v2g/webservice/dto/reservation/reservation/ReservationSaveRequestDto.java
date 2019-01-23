package com.v2g.webservice.dto.reservation.reservation;

import java.io.Serializable;

import com.v2g.webservice.domain.reservation.reservation.Reservation;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationSaveRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	private String userid;
	private String place;
	private String rdate;
	private String rtime;
	private String rflag;
	private String rcost;
	private String relectirc;
	private String residual;
	private String usersms;

    @Builder
    public ReservationSaveRequestDto(long id, String userid, String place, String rdate, String rtime, String rflag, String rcost, String relectirc, String residual) {
    	this.id = id;
    	this.userid = userid;
        this.place = place;
        this.rdate = rdate;
        this.rtime = rtime;
        this.rflag = rflag;
        this.rcost = rcost;
        this.relectirc = relectirc;
        this.residual = residual;
    }
    
    
    public Reservation toEntity(){
        return Reservation.builder()
        		.id(id)
        		.userid(userid)
        		.place(place)
        		.rdate(rdate)
        		.rtime(rtime)
                .rflag(rflag)
                .rcost(rcost)
                .relectirc(relectirc)
                .residual(residual)
                .build();
    }
}