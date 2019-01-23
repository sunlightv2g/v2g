package com.v2g.webservice.domain.reservation.reservation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.v2g.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Reservation extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255, nullable = false)
    private String userid;
    
    @Column(length = 255, nullable = false)
    private String place;
    
    @Column(length = 255, nullable = false)
    private String rdate;
    
    @Column(length = 255, nullable = true)
    private String rtime;
    
    @Column(length = 255, nullable = true)
    private String rflag;
    
    @Column(length = 255, nullable = true)
    private String rcost;
    
    @Column(length = 255, nullable = true)
    private String relectirc;
    
    @Column(length = 255, nullable = true)
    private String rleft;
    
    @Builder
    public Reservation(long id, String userid, String place, String rdate, String rtime, String rflag, String rcost, String relectirc, String rleft) {
    	this.id = id;
    	this.userid = userid;
        this.place = place;
        this.rdate = rdate;
        this.rtime = rtime;
        this.rflag = rflag;
        this.rcost = rcost;
        this.relectirc = relectirc;
        this.rleft = rleft;
    }
}