package com.v2g.webservice.domain.main.maindata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.JPQLQuery;
import com.v2g.webservice.dto.customer.customer.CustomerMainCenterDataResponseDto;
import com.v2g.webservice.dto.main.maindata.MaindataMainResponseDto;
import com.v2g.webservice.dto.main.maindata.MaindataSearchRequestDto;

@Repository
public class MaindataRepositoryImpl extends QueryDslRepositorySupport implements MaindataCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public MaindataRepositoryImpl() {
        super(Maindata.class);
    }
    
    @Override
    public long getMaindataByQuerydsl(String dayflag) {
    	QMaindata maindata = QMaindata.maindata;
    	JPQLQuery query = from(maindata);
    	query.where(maindata.dayflag.eq(dayflag));
    	return query.fetchCount();
    }
    
    @Override
    public long getMaindataByQuerydsl(String dayflag, String userpass) {
    	QMaindata maindata = QMaindata.maindata;
    	JPQLQuery query = from(maindata);
    	query.where(maindata.dayflag.eq(dayflag));
    	return query.fetchCount();
    }

	@Override
    public Page<MaindataMainResponseDto> getMaindataList(MaindataSearchRequestDto maindataSearchResponseDto, Pageable pageable)  {

        QMaindata maindata = QMaindata.maindata;
        
        JPQLQuery query = from(maindata);
        if(!StringUtils.isEmpty(maindataSearchResponseDto.getDayflag())) {
        	if(maindataSearchResponseDto.getDayflag().equals("all")) {
        		query.where(maindata.dayflag.like("%" + maindataSearchResponseDto.getDayflag() + "%"));
        	}
	        if(maindataSearchResponseDto.getDayflag().equals("dayflag")) {
	        	query.where(maindata.dayflag.like("%" + maindataSearchResponseDto.getDayflag() + "%"));
	        }
        }
        
        query.orderBy(maindata.id.desc());
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        
        List<MaindataMainResponseDto> result = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();
        
        return new PageImpl<>(result, pageable, totalCount);
    }
	
	@Override
    public CustomerMainCenterDataResponseDto getMainCenterData(MaindataSearchRequestDto maindataSearchRequestDto) {
    	
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
    	String query = "select "; 
			query += "sum(vcar) as vcar ";
			query += ",sum(vcost) as vcost ";
			query += ",sum(velectric) as velectric ";
			query += ",sum(vaccure) as vaccure ";
			query += ",sum(carcnt) as carcnt ";
			query += "from maindata  ";
			query += "where dayflag = :dayflag ";
			
    	System.out.println(query);
    	Query q = entityManager.createNativeQuery(query);
	    q.setParameter("dayflag", maindataSearchRequestDto.getDayflag());
	    List<Object> result = (List<Object>) q.getResultList();
	    
	    CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = new CustomerMainCenterDataResponseDto();
    	Iterator itr = result.iterator();
    	while(itr.hasNext()){
    		
    	   Object[] obj = (Object[]) itr.next();

    	   customerMainCenterDataResponseDto.setVcar(String.valueOf(obj[0]));
    	   customerMainCenterDataResponseDto.setVcost(String.valueOf(obj[1]));
    	   customerMainCenterDataResponseDto.setVelectric(String.valueOf(obj[2]));
    	   customerMainCenterDataResponseDto.setVaccure(String.valueOf(obj[3]));
    	   customerMainCenterDataResponseDto.setCarcnt(String.valueOf(obj[4]));
    	}
	    
   	
    	return customerMainCenterDataResponseDto;
    	
    }
	
	
		
/*	@Override
	public long update(Maindata entity) {
    	QMaindata maindata = QMaindata.maindata;
    	
    	long rstCnt = new JPAUpdateClause(entityManager, maindata).where(maindata.id.eq(entity.getId()))
    	.set(maindata.userno, entity.getUserno())
        .set(maindata.dayflag, entity.getUserid())
        .set(maindata.addr, entity.getAddr())
        .set(maindata.nowday, entity.getNowday())
        .set(maindata.accrue, entity.getAccrue())
        .set(maindata.contact, entity.getContact())
        .set(maindata.nowcal, entity.getNowcal())
        .set(maindata.accruecal, entity.getAccruecal())
        .execute();
    	    	
    	return rstCnt;
	}*/
}