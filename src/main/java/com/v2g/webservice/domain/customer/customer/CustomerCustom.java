package com.v2g.webservice.domain.customer.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.v2g.webservice.dto.customer.customer.CustomerMainResponseDto;
import com.v2g.webservice.dto.customer.customer.CustomerSearchRequestDto;
import com.v2g.webservice.dto.main.maindata.MainCenterDataResponseDto;
import com.v2g.webservice.dto.main.maindata.MaindataSearchRequestDto;

public interface CustomerCustom {
    Page<CustomerMainResponseDto> getCustomerList(CustomerSearchRequestDto customerSearchResponseDto, Pageable pageable);
    long getCustomerByQuerydsl(String userid);
    long getCustomerByQuerydsl(String userid, String userpass);
    
	/*long update(Customer entity);*/
}