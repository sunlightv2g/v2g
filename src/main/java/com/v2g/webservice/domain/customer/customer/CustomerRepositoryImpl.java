package com.v2g.webservice.domain.customer.customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.ParamExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.v2g.webservice.dto.customer.customer.CustomerMainResponseDto;
import com.v2g.webservice.dto.customer.customer.CustomerSearchRequestDto;

@Repository
public class CustomerRepositoryImpl extends QueryDslRepositorySupport implements CustomerCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }
    
    @Override
    public long getCustomerByQuerydsl(String userid) {
    	QCustomer customer = QCustomer.customer;
    	JPQLQuery query = from(customer);
    	query.where(customer.userid.eq(userid));
    	return query.fetchCount();
    }
    
    @Override
    public long getCustomerByQuerydsl(String userid, String userpass) {
    	QCustomer customer = QCustomer.customer;
    	JPQLQuery query = from(customer);
    	query.where(customer.userid.eq(userid));
    	return query.fetchCount();
    }

	@Override
    public Page<CustomerMainResponseDto> getCustomerList(CustomerSearchRequestDto customerSearchResponseDto, Pageable pageable)  {

        QCustomer customer = QCustomer.customer;
        
        JPQLQuery query = from(customer);
        if(!StringUtils.isEmpty(customerSearchResponseDto.getSearchStr())) {
        	if(customerSearchResponseDto.getSearchFlag().equals("all")) {
        		query.where(customer.userid.like("%" + customerSearchResponseDto.getSearchStr() + "%"));
        	}
	        if(customerSearchResponseDto.getSearchFlag().equals("userid")) {
	        	query.where(customer.userid.like("%" + customerSearchResponseDto.getSearchStr() + "%"));
	        }
        }
        
        query.orderBy(customer.id.desc());
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        
        List<CustomerMainResponseDto> result = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();
        
        return new PageImpl<>(result, pageable, totalCount);
    }
		
/*	@Override
	public long update(Customer entity) {
    	QCustomer customer = QCustomer.customer;
    	
    	long rstCnt = new JPAUpdateClause(entityManager, customer).where(customer.id.eq(entity.getId()))
    	.set(customer.userno, entity.getUserno())
        .set(customer.userid, entity.getUserid())
        .set(customer.addr, entity.getAddr())
        .set(customer.nowday, entity.getNowday())
        .set(customer.accrue, entity.getAccrue())
        .set(customer.contact, entity.getContact())
        .set(customer.nowcal, entity.getNowcal())
        .set(customer.accruecal, entity.getAccruecal())
        .execute();
    	    	
    	return rstCnt;
	}*/
}