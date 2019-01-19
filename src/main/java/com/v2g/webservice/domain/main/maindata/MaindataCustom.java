package com.v2g.webservice.domain.main.maindata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.v2g.webservice.dto.customer.customer.CustomerMainCenterDataResponseDto;
import com.v2g.webservice.dto.main.maindata.MaindataMainResponseDto;
import com.v2g.webservice.dto.main.maindata.MaindataSearchRequestDto;

public interface MaindataCustom {
    Page<MaindataMainResponseDto> getMaindataList(MaindataSearchRequestDto maindataSearchResponseDto, Pageable pageable);
    long getMaindataByQuerydsl(String userid);
    long getMaindataByQuerydsl(String userid, String userpass);
    CustomerMainCenterDataResponseDto getMainCenterData(MaindataSearchRequestDto maindataSearchRequestDto);
	/*long update(Maindata entity);*/
    
    
}