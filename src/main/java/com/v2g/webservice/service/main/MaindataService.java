package com.v2g.webservice.service.main;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v2g.webservice.domain.main.maindata.MaindataRepository;
import com.v2g.webservice.dto.main.maindata.MainDataResponseDto;
import com.v2g.webservice.dto.main.maindata.MaindataMainResponseDto;
import com.v2g.webservice.dto.main.maindata.MaindataSearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MaindataService {
    private MaindataRepository maindataRepository;

/*    @Transactional
    public long save(MaindataSaveRequestDto dto){
        return maindataRepository.save(dto.toEntity()).getId();
    }*/
    
/*    @Transactional
    public long update(MaindataSaveRequestDto dto){
    	return maindataRepository.update(dto.toEntity());
    }*/
   
    @Transactional(readOnly = true)
    public Page<MaindataMainResponseDto> getMaindataListByQueryDSL(MaindataSearchRequestDto maindataSearchResponseDto, Pageable pageable) {
        return maindataRepository.getMaindataList(maindataSearchResponseDto, pageable);
    }
    
    @Transactional(readOnly = true)
    public long getMaindata(String userid) {
        return maindataRepository.getMaindataByQuerydsl(userid);
    }
    
    @Transactional
    public void getMaindataDelete(long id) {
    	maindataRepository.delete(id);
    }
    
    @Transactional(readOnly = true)
    public long getMaindata(String userid,String userpass ) {
    	return maindataRepository.getMaindataByQuerydsl(userid, userpass);
    }
    
    @Transactional(readOnly = true)
    public List<MainDataResponseDto> getMainDataTable(MaindataSearchRequestDto maindataSearchRequestDto) {
    	return maindataRepository.getMainDataTable(maindataSearchRequestDto);
    }
    
    @Transactional(readOnly = true)
    public MainDataResponseDto getMainCenterData(MaindataSearchRequestDto maindataSearchRequestDto) {
    	
    	if(maindataSearchRequestDto.getDayflag() == null || maindataSearchRequestDto.getDayflag().equals("")) {
    		Calendar cal = Calendar.getInstance();
        	int day = cal.get(cal.DATE);
    		maindataSearchRequestDto.setDayflag(String.valueOf(day));
    	}
    	
    	if(Integer.parseInt(maindataSearchRequestDto.getDayflag()) > 0 && Integer.parseInt(maindataSearchRequestDto.getDayflag()) < 31) {
    		
    	}else {
    		maindataSearchRequestDto.setDayflag("1");
    	}
    	System.out.println("dayflag : " + maindataSearchRequestDto.getDayflag());
    	return maindataRepository.getMainCenterData(maindataSearchRequestDto);
    }
    
    
    
    
    
}