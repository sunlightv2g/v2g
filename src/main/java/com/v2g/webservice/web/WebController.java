package com.v2g.webservice.web;

import java.util.Calendar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.v2g.webservice.dto.customer.customer.CustomerMainCenterDataResponseDto;
import com.v2g.webservice.dto.customer.customer.CustomerMainResponseDto;
import com.v2g.webservice.dto.customer.customer.CustomerSearchRequestDto;
import com.v2g.webservice.dto.environment.userinfo.UserinfoMainResponseDto;
import com.v2g.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;
import com.v2g.webservice.dto.main.maindata.MaindataSearchRequestDto;
import com.v2g.webservice.service.customer.CustomerService;
import com.v2g.webservice.service.environment.UserinfoService;
import com.v2g.webservice.service.main.MaindataService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private UserinfoService userinfoService;
	private CustomerService customerService;
	private MaindataService maindataService;
	
    @GetMapping("/")
    public String main(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
        //return "main";
    	return "redirect:/main";
    }
	
    @GetMapping("/main")
    public String mainMain(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
		CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
		model.addAttribute("centerdata", customerMainCenterDataResponseDto);
    	
    	return "main/main";
    }
    
    @GetMapping("/seoul")
    public String mainSeoul(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
		CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
		model.addAttribute("centerdata", customerMainCenterDataResponseDto);
		
    	return "main/seoul";
    }
    
    @GetMapping("/apt")
    public String mainApt(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
		CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
		model.addAttribute("centerdata", customerMainCenterDataResponseDto);
		
    	return "main/apt";
    }
    
    @GetMapping("/location")
    public String mainLocation(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
   		CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", customerMainCenterDataResponseDto);
   		
    	return "main/location";
    }
    
    @GetMapping("/customer")
    public String customer(Model model, MaindataSearchRequestDto maindataSearchRequestDto, CustomerSearchRequestDto customerSearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    	
   		CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", customerMainCenterDataResponseDto);
    	
    	Page<CustomerMainResponseDto> customerMainResponseDto = customerService.getCustomerListByQueryDSL(customerSearchResponseDto, pageable);
		
		model.addAttribute("search", customerSearchResponseDto);
		model.addAttribute("dataList", customerMainResponseDto);
		
		model.addAttribute("currentPage", pageable.getPageNumber()+1);
		model.addAttribute("countPerPageGroup",pageable.getPageSize());
		model.addAttribute("totlalCount", customerMainResponseDto.getTotalElements());
		model.addAttribute("totlalPageCount", customerMainResponseDto.getTotalPages());
    	return "customer/customer";
    }
    
    @GetMapping("/trade")
    public String trade(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
   		CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", customerMainCenterDataResponseDto);
   		
    	return "trade/trade";
    }
    
    @GetMapping("/analysis")
    public String analysis(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
    	CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", customerMainCenterDataResponseDto);
   		
    	return "analysis/analysis";
    }
    
    @GetMapping("/reservation")
    public String reservation(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
    	CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", customerMainCenterDataResponseDto);
   		
    	return "reservation/reservation";
    }
    
    @GetMapping("/environment")
    public String environment(Model model, MaindataSearchRequestDto maindataSearchRequestDto, UserinfoSearchRequestDto userinfoSearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    
   		CustomerMainCenterDataResponseDto customerMainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", customerMainCenterDataResponseDto);
   		
		Page<UserinfoMainResponseDto> userinfoMainResponseDto = userinfoService.getUserinfoListByQueryDSL(userinfoSearchResponseDto, pageable);
		
		model.addAttribute("search", userinfoSearchResponseDto);
		model.addAttribute("dataList", userinfoMainResponseDto);
		
		model.addAttribute("currentPage", pageable.getPageNumber()+1);
		model.addAttribute("countPerPageGroup",pageable.getPageSize());
		model.addAttribute("totlalCount", userinfoMainResponseDto.getTotalElements());
		model.addAttribute("totlalPageCount", userinfoMainResponseDto.getTotalPages());
    	return "environment/environment";
    }
	
    
    
}
