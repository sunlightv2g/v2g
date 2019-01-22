package com.v2g.webservice.domain.analysis.analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.v2g.webservice.dto.analysis.analysis.AnalysisResponseDto;
import com.v2g.webservice.dto.analysis.analysis.AnalysisSearchRequestDto;

@Repository
public class AnalysisRepositoryImpl extends QueryDslRepositorySupport implements AnalysisCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public AnalysisRepositoryImpl() {
        super(Analysis.class);
    }
    
    @Override
    public List<AnalysisResponseDto> getAnalysisList(AnalysisSearchRequestDto analysisSearchRequestDto) {
    	
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
    	String query = "select "; 
				query += "vflag ";
				query += ", vpcost ";
				query += ", vpelectric ";
				query += ", vcost ";
				query += ", velectric ";
				query += ",dayflag ";
				query += "from ";
				query += " analysis ";
				query += " where dayflag > 0 and dayflag < 31 ";
				query += " order by dayflag asc ";

    	System.out.println(query);
    	Query q = entityManager.createNativeQuery(query);
	    List<Object> result = (List<Object>) q.getResultList();
	    
	    List<AnalysisResponseDto> mainDataResponseDtoList = new ArrayList<AnalysisResponseDto>();
    	Iterator itr = result.iterator();
    	while(itr.hasNext()){
    		AnalysisResponseDto mainDataResponseDto = new AnalysisResponseDto();
    	   Object[] obj = (Object[]) itr.next();
    	   
    	   mainDataResponseDto.setVflag(String.valueOf(obj[0]));
    	   mainDataResponseDto.setVpcost(String.valueOf(obj[1]));
    	   mainDataResponseDto.setVpelectric(String.valueOf(obj[2]));
    	   mainDataResponseDto.setVcost(String.valueOf(obj[3]));
    	   mainDataResponseDto.setVelectric(String.valueOf(obj[4]));
    	   mainDataResponseDto.setDayflag(String.valueOf(obj[5]));
    	   mainDataResponseDtoList.add(mainDataResponseDto);
    	}
   	
    	return mainDataResponseDtoList;
    	
    }
    
}