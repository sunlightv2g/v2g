package com.v2g.webservice.domain.analysis.analysis;

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
public class Analysis extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String vflag;
    
    @Column
    private int vpcost;
    
    @Column
    private int vpelectric;
    
    @Column
    private int vcost;
    
    @Column
    private int velectric;
    
    @Builder
    public Analysis(long id, String vflag, String vlocation, int vpcost, int vpelectric, int vcost, int velectric) {
    	this.id = id;
    	this.vflag = vflag;
        this.vflag = vflag;
        this.vpcost = vpcost;
        this.vpelectric = vpelectric;
        this.vcost = vcost;
        this.velectric = velectric;
    }
}