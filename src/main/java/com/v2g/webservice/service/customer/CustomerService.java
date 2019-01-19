package com.v2g.webservice.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v2g.webservice.domain.customer.customer.CustomerRepository;
import com.v2g.webservice.dto.customer.customer.CustomerMainResponseDto;
import com.v2g.webservice.dto.customer.customer.CustomerSearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {
    private CustomerRepository customerRepository;

/*    @Transactional
    public long save(CustomerSaveRequestDto dto){
        return customerRepository.save(dto.toEntity()).getId();
    }*/
    
/*    @Transactional
    public long update(CustomerSaveRequestDto dto){
    	return customerRepository.update(dto.toEntity());
    }*/
   
    @Transactional(readOnly = true)
    public Page<CustomerMainResponseDto> getCustomerListByQueryDSL(CustomerSearchRequestDto customerSearchResponseDto, Pageable pageable) {
        return customerRepository.getCustomerList(customerSearchResponseDto, pageable);
    }
    
    @Transactional(readOnly = true)
    public long getCustomer(String userid) {
        return customerRepository.getCustomerByQuerydsl(userid);
    }
    
    
    @Transactional
    public void getCustomerDelete(long id) {
    	customerRepository.delete(id);
    }
    
    @Transactional(readOnly = true)
    public long getCustomer(String userid,String userpass ) {
    	return customerRepository.getCustomerByQuerydsl(userid, userpass);
    }
    
}