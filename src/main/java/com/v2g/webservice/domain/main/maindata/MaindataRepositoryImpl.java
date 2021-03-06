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
import com.v2g.webservice.dto.main.maindata.MainBateryResponseDto;
import com.v2g.webservice.dto.main.maindata.MainDataResponseDto;
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
    public List<MainDataResponseDto> getMainDataTable(MaindataSearchRequestDto maindataSearchRequestDto) {
    	
    	String tbName = maindataSearchRequestDto.getTablename();
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
    	String query = "select "; 
			
			switch (tbName) {
			case "maindata":
				query += " vcar ";
				query += ",round(vcost * 0.001,1) as vcost ";
				query += ",round(velectric * 0.001,1) as velectric ";
				query += ",round(vaccure * 0.001,1) as vaccure ";
				query += ",carcnt ";
				query += ",location ";
				query += ", '' as vr​esidual ";
				query += ", '' as vreservation ";
				query += ", '' as building ";
				query += ", '' as userid ";
				query += "from ";
				query += " maindata ";
				break;
			case "seoul":
				query += " vcar ";
				query += ",round(vcost,1) as vcost ";
				query += ",round(velectric,1) as velectric ";
				query += ",round(vaccure,1) as vaccure ";
				query += ",carcnt ";
				query += ",location ";
				query += ", '' as vr​esidual ";
				query += ", '' as vreservation ";
				query += ", '' as building ";
				query += ", '' as userid ";
				query += "from ";
				query += " seoul ";
				break;				
			case "location":
				query += " vcar ";
				query += ",round(vcost,1) as vcost ";
				query += ",round(velectric,1) as velectric ";
				query += ",round(vaccure,1) as vaccure ";
				query += ",carcnt ";
				query += ",location ";
				query += ", '' as vr​esidual ";
				query += ", '' as vreservation ";
				query += ", '' as building ";
				query += ", '' as userid ";
				query += "from ";
				query += " location ";
				break;
			case "apt":
				query += " '' as vcar ";
				query += ",vcost ";
				query += ",velectric ";
				query += ",vaccure ";
				query += ", '' as carcnt ";
				query += ", '' as location ";
				query += ",vr​esidual ";
				query += ",vreservation ";
				query += ",building ";
				query += ",userid ";
				query += "from ";
				query += " aptdata ";
				break;
			
			}
			
			query += "where dayflag = :dayflag ";
			
    	System.out.println(query);
    	Query q = entityManager.createNativeQuery(query);
	    q.setParameter("dayflag", maindataSearchRequestDto.getDayflag());
	    List<Object> result = (List<Object>) q.getResultList();
	    
	    List<MainDataResponseDto> mainDataResponseDtoList = new ArrayList<MainDataResponseDto>();
    	Iterator itr = result.iterator();
    	while(itr.hasNext()){
    		MainDataResponseDto mainDataResponseDto = new MainDataResponseDto();
    	   Object[] obj = (Object[]) itr.next();

    	   mainDataResponseDto.setVcar(String.valueOf(obj[0]));
    	   mainDataResponseDto.setVcost(String.valueOf(obj[1]));
    	   mainDataResponseDto.setVelectric(String.valueOf(obj[2]));
    	   mainDataResponseDto.setVaccure(String.valueOf(obj[3]));
    	   mainDataResponseDto.setCarcnt(String.valueOf(obj[4]));
    	   mainDataResponseDto.setLocation(String.valueOf(obj[5]));
    	   mainDataResponseDto.setVleft(String.valueOf(obj[6]));
    	   mainDataResponseDto.setVreservation(String.valueOf(obj[7]));
    	   mainDataResponseDto.setBuilding(String.valueOf(obj[8]));
    	   mainDataResponseDto.setUserid(String.valueOf(obj[9]));
    	   mainDataResponseDtoList.add(mainDataResponseDto);
    	}
   	
    	return mainDataResponseDtoList;
    	
    }
    
    @Override
    public List<MainBateryResponseDto> getBateryDataTable(MaindataSearchRequestDto maindataSearchRequestDto) {
    	
    	String tbName = maindataSearchRequestDto.getTablename();
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
    	String query = "select "; 
		query += " building ";
		query += ",flag ";
		query += ",vdata ";
		query += "from ";
		query += " baterydata ";
    	query += "where dayflag = :dayflag ";
    	
    	System.out.println(query);
    	Query q = entityManager.createNativeQuery(query);
    	q.setParameter("dayflag", maindataSearchRequestDto.getDayflag());
    	List<Object> result = (List<Object>) q.getResultList();
    	
    	List<MainBateryResponseDto> mainBateryResponseDtoList = new ArrayList<MainBateryResponseDto>();
    	Iterator itr = result.iterator();
    	while(itr.hasNext()){
    		MainBateryResponseDto mainBateryResponseDto = new MainBateryResponseDto();
    		Object[] obj = (Object[]) itr.next();
    		
    		mainBateryResponseDto.setBuilding(String.valueOf(obj[0]));
    		mainBateryResponseDto.setFlag(String.valueOf(obj[1]));
    		mainBateryResponseDto.setVdata(String.valueOf(obj[2]));
    		mainBateryResponseDtoList.add(mainBateryResponseDto);
    	}
    	
    	return mainBateryResponseDtoList;
    	
    }
    
    
    
   /* @Override
    public MaindataMainResponseDto getMaindataLocation(MaindataSearchRequestDto maindataSearchRequestDto) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

        QMaindata maindata = QMaindata.maindata;

        return queryFactory.select(
        		Projections.constructor(MaindataMainResponseDto.class, 
        				maindata.vcar
        				, maindata.vcost
        				, maindata.velectric
        				, maindata.vaccure
        				, maindata.carcnt
        				))
                .from(maindata)
                .where(maindata.dayflag.eq(maindataSearchRequestDto.getDayflag()))
                .where(maindata.location.eq(maindataSearchRequestDto.getLocation()))
                .fetchOne();

    }*/
    
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
    public MainDataResponseDto getMainCenterData(MaindataSearchRequestDto maindataSearchRequestDto) {
    	
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
    	String query = "select "; 
			query += "sum(vcar) as vcar ";
			query += ",round(sum(vcost) * 0.001,1) as vcost ";
			query += ",round(sum(velectric) * 0.001,1) as velectric ";
			query += ",round(sum(vaccure) * 0.001,1) as vaccure ";
			query += ",sum(carcnt) as carcnt ";
			query += "from maindata  ";
			query += "where dayflag = :dayflag ";
			
    	System.out.println(query);
    	Query q = entityManager.createNativeQuery(query);
	    q.setParameter("dayflag", maindataSearchRequestDto.getDayflag());
	    List<Object> result = (List<Object>) q.getResultList();
	    
	    MainDataResponseDto mainCenterDataResponseDto = new MainDataResponseDto();
    	Iterator itr = result.iterator();
    	while(itr.hasNext()){
    		
    	   Object[] obj = (Object[]) itr.next();

    	   mainCenterDataResponseDto.setVcar(String.valueOf(obj[0]));
    	   mainCenterDataResponseDto.setVcost(String.valueOf(obj[1]));
    	   mainCenterDataResponseDto.setVelectric(String.valueOf(obj[2]));
    	   mainCenterDataResponseDto.setVaccure(String.valueOf(obj[3]));
    	   mainCenterDataResponseDto.setCarcnt(String.valueOf(obj[4]));
    	}
	    
    	mainCenterDataResponseDto.setDayflag(maindataSearchRequestDto.getDayflag());
   	
    	return mainCenterDataResponseDto;
    	
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