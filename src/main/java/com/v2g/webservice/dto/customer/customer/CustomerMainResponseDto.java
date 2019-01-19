package com.v2g.webservice.dto.customer.customer;

import java.io.Serializable;

import com.v2g.webservice.domain.customer.customer.Customer;

import lombok.Getter;

@Getter
public class CustomerMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String userno;
    private String userid;
    private String addr;
    private String nowday;
    private String accrue;
    private String contact;
    private String nowcal;
    private String accruecal;

    public CustomerMainResponseDto(Customer entity) {
        id = entity.getId();
        userno = entity.getUserno();
        userid = entity.getUserid();
        addr = entity.getAddr();
        nowday = entity.getNowday();
        accrue = entity.getAccrue();
        contact = entity.getContact();
        nowcal = entity.getNowcal();
        accruecal = entity.getAccruecal();
    }
    
}