package com.v2g.webservice.domain.reservation.reservation;

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
import com.v2g.webservice.dto.analysis.analysis.AnalysisResponseDto;
import com.v2g.webservice.dto.reservation.reservation.ReservationMainResponseDto;
import com.v2g.webservice.dto.reservation.reservation.ReservationResponseDto;
import com.v2g.webservice.dto.reservation.reservation.ReservationSearchRequestDto;

@Repository
public class ReservationRepositoryImpl extends QueryDslRepositorySupport implements ReservationCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public ReservationRepositoryImpl() {
        super(Reservation.class);
    }
    
    @Override
    public long getReservationByQuerydsl(String userid) {
    	QReservation reservation = QReservation.reservation;
    	JPQLQuery query = from(reservation);
    	query.where(reservation.userid.eq(userid));
    	return query.fetchCount();
    }
    
/*    @Override
    public long getReservationByQuerydsl(String userid, String userpass) {
    	QReservation reservation = QReservation.reservation;
    	JPQLQuery query = from(reservation);
    	query.where(reservation.userid.eq(userid));
    	query.where(reservation.userpass.eq(userpass));
    	return query.fetchCount();
    }*/

	@Override
    public Page<ReservationMainResponseDto> getReservationList(ReservationSearchRequestDto reservationSearchResponseDto, Pageable pageable)  {

        QReservation reservation = QReservation.reservation;
        
        JPQLQuery query = from(reservation);
        if(!StringUtils.isEmpty(reservationSearchResponseDto.getSearchStr())) {
        	
	        if(reservationSearchResponseDto.getSearchFlag().equals("userid")) {
	        	query.where(reservation.userid.like("%" + reservationSearchResponseDto.getSearchStr() + "%"));
	        }
        }
        
        query.orderBy(reservation.id.desc());
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        
        List<ReservationMainResponseDto> result = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();
        
        return new PageImpl<>(result, pageable, totalCount);
    }
	
	@Override
    public List<ReservationResponseDto> getTodayCost() {
    	
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
    	String query = "select "; 
				query += "timeflag ";
				query += ", vcost ";
				query += "from ";
				query += " todaycost ";
				query += " where 1=1 ";
				query += " order by id asc ";

    	System.out.println(query);
    	Query q = entityManager.createNativeQuery(query);
	    List<Object> result = (List<Object>) q.getResultList();
	    
	    List<ReservationResponseDto> reservationResponseDtoList = new ArrayList<ReservationResponseDto>();
    	Iterator itr = result.iterator();
    	while(itr.hasNext()){
    		ReservationResponseDto reservationResponseDto = new ReservationResponseDto();
    	   Object[] obj = (Object[]) itr.next();
    	   
    	   reservationResponseDto.setTimeflag(String.valueOf(obj[0]));
    	   reservationResponseDto.setVcost(String.valueOf(obj[1]));
    	   
    	   reservationResponseDtoList.add(reservationResponseDto);
    	}
   	
    	return reservationResponseDtoList;
    	
    }
	
	@Override
    public List<ReservationResponseDto> getTradeHistory() {
    	
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
    	String query = "select "; 
    			query += "vflag ";
				query += ",vcost ";
				query += ",velectric ";
				query += "from ";
				query += " tradehistory ";
				query += " where 1=1 ";
				query += " order by id asc ";

    	System.out.println(query);
    	Query q = entityManager.createNativeQuery(query);
	    List<Object> result = (List<Object>) q.getResultList();
	    
	    List<ReservationResponseDto> reservationResponseDtoList = new ArrayList<ReservationResponseDto>();
    	Iterator itr = result.iterator();
    	while(itr.hasNext()){
    		ReservationResponseDto reservationResponseDto = new ReservationResponseDto();
    	   Object[] obj = (Object[]) itr.next();
    	   
    	   reservationResponseDto.setVflag(String.valueOf(obj[0]));
    	   reservationResponseDto.setVcost(String.valueOf(obj[1]));
    	   reservationResponseDto.setVelectric(String.valueOf(obj[2]));
    	   
    	   reservationResponseDtoList.add(reservationResponseDto);
    	}
   	
    	return reservationResponseDtoList;
    	
    }
	
	
	
/*		
	@Override
	public long update(Reservation entity) {
    	QReservation reservation = QReservation.reservation;
    	
    	long rstCnt = new JPAUpdateClause(entityManager, reservation).where(reservation.id.eq(entity.getId()))
        .set(reservation.userid, entity.getUserid())
        .set(reservation.username, entity.getUsername())
        .set(reservation.userrole, entity.getUserrole())
        .set(reservation.userpart, entity.getUserpart())
        .set(reservation.userhp, entity.getUserhp())
        .set(reservation.usertel, entity.getUsertel())
        .set(reservation.useremail, entity.getUseremail())
        .set(reservation.usersms, entity.getUsersms())
        .execute();
    	    	
    	return rstCnt;
		
	}*/
}