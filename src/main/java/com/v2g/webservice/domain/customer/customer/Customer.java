package com.v2g.webservice.domain.customer.customer;

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
public class Customer extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255, nullable = false)
    private String userno;
    
    @Column(length = 255, nullable = false)
    private String userid;
    
    @Column(length = 255, nullable = false)
    private String addr;
    
    @Column(length = 255, nullable = true)
    private String nowday;
    
    @Column(length = 255, nullable = true)
    private String accrue;
    
    @Column(length = 255, nullable = true)
    private String contact;
    
    @Column(length = 255, nullable = true)
    private String nowcal;
    
    @Column(length = 255, nullable = true)
    private String accruecal;
    
    @Builder
    public Customer(long id, String userno, String userid, String addr, String nowday, String accrue, String contact, String nowcal, String accruecal) {
    	this.id = id;
    	this.userno = userno;
    	this.userid = userid;
        this.addr = addr;
        this.nowday = nowday;
        this.accrue = accrue;
        this.contact = contact;
        this.nowcal = nowcal;
        this.accruecal = accruecal;
    }
}