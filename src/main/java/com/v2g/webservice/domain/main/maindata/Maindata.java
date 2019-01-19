package com.v2g.webservice.domain.main.maindata;

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
public class Maindata extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255, nullable = false)
    private String location;
    
    @Column
    private int vcar;
    
    @Column
    private int vcost;
    
    @Column
    private int velectric;
    
    @Column
    private int vaccure;
    
    @Column(length = 255, nullable = false)
    private String dayflag;
    
    @Column
    private int carcnt;
    
    
    @Builder
    public Maindata(long id, String location, int vcar, int vcost, int velectric, int vaccure, String dayflag, int carcnt) {
    	this.id = id;
    	this.location = location;
    	this.vcar = vcar;
        this.vcost = vcost;
        this.velectric = velectric;
        this.vaccure = vaccure;
        this.dayflag = dayflag;
        this.carcnt = carcnt;
    }
}