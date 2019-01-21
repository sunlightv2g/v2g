package com.v2g.webservice.domain.main.maindata;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.v2g.webservice.dto.main.maindata.MainDataResponseDto;
import com.v2g.webservice.dto.main.maindata.MaindataMainResponseDto;
import com.v2g.webservice.dto.main.maindata.MaindataSearchRequestDto;

public interface MaindataCustom {
    Page<MaindataMainResponseDto> getMaindataList(MaindataSearchRequestDto maindataSearchResponseDto, Pageable pageable);
    long getMaindataByQuerydsl(String userid);
    long getMaindataByQuerydsl(String userid, String userpass);
    MainDataResponseDto getMainCenterData(MaindataSearchRequestDto maindataSearchRequestDto);
	/*long update(Maindata entity);*/
    List<MainDataResponseDto> getMainDataTable(MaindataSearchRequestDto maindataSearchRequestDto);
    
}