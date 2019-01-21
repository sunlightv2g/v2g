package com.v2g.webservice.domain.trade.trade;

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
public class Trade extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String vtime;
    
    @Column(length = 50, nullable = false)
    private String vlocation;
    
    @Column(length = 50, nullable = false)
    private String vflag;
    
    @Column
    private int vcost;
    
    @Column
    private int velectric;
    
   
    
    
    @Builder
    public Trade(long id, String vtime, String vlocation, String vflag, int vcost, int velectric) {
    	this.id = id;
    	this.vtime = vtime;
    	this.vlocation = vlocation;
        this.vflag = vflag;
        this.vcost = vcost;
        this.velectric = velectric;
    }
}