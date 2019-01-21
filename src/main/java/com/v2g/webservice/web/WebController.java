package com.v2g.webservice.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.v2g.webservice.dto.customer.customer.CustomerMainResponseDto;
import com.v2g.webservice.dto.customer.customer.CustomerSearchRequestDto;
import com.v2g.webservice.dto.environment.userinfo.UserinfoMainResponseDto;
import com.v2g.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;
import com.v2g.webservice.dto.main.maindata.MainDataResponseDto;
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
		MainDataResponseDto mainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
		model.addAttribute("centerdata", mainCenterDataResponseDto);

		maindataSearchRequestDto.setDayflag(mainCenterDataResponseDto.getDayflag());
		maindataSearchRequestDto.setTablename("maindata");
		
		List<MainDataResponseDto> mainDataResponseDtoList = maindataService.getMainDataTable(maindataSearchRequestDto);
		
		for(MainDataResponseDto mainDataResponseDto : mainDataResponseDtoList) {
			switch (mainDataResponseDto.getLocation()) {
			case "서울":
				model.addAttribute("seoul", mainDataResponseDto);
				break;
			case "경기":
				model.addAttribute("kyungki", mainDataResponseDto);
				break;
			case "강원":
				model.addAttribute("kangwon", mainDataResponseDto);
				break;
			case "충청북도":
				model.addAttribute("chungbuk", mainDataResponseDto);
				break;
			case "충청남도":
				model.addAttribute("chungnam", mainDataResponseDto);
				break;
			case "전라북도":
				model.addAttribute("junlabuk", mainDataResponseDto);
				break;
			case "전라남도":
				model.addAttribute("junlanam", mainDataResponseDto);
				break;
			case "경상북도":
				model.addAttribute("kyungsangbuk", mainDataResponseDto);
				break;
			case "경상남도":
				model.addAttribute("kyungsangnam", mainDataResponseDto);
				break;
			case "제주도":
				model.addAttribute("jeju", mainDataResponseDto);
				break;				
				
			}
		}

		
    	return "main/main";
    }
    
    @GetMapping("/seoul")
    public String mainSeoul(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
		MainDataResponseDto mainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
		model.addAttribute("centerdata", mainCenterDataResponseDto);
		
		maindataSearchRequestDto.setDayflag(mainCenterDataResponseDto.getDayflag());
		maindataSearchRequestDto.setTablename("seoul");
		
		List<MainDataResponseDto> mainDataResponseDtoList = maindataService.getMainDataTable(maindataSearchRequestDto);
		
		for(MainDataResponseDto mainDataResponseDto : mainDataResponseDtoList) {
			switch (mainDataResponseDto.getLocation()) {
			case "은평구":
				model.addAttribute("gu01", mainDataResponseDto);
				break;
			case "도봉구":
				model.addAttribute("gu02", mainDataResponseDto);
				break;
			case "강북구":
				model.addAttribute("gu03", mainDataResponseDto);
				break;
			case "노원구":
				model.addAttribute("gu04", mainDataResponseDto);
				break;
			case "성북구":
				model.addAttribute("gu05", mainDataResponseDto);
				break;
			case "서대문구":
				model.addAttribute("gu06", mainDataResponseDto);
				break;
			case "종로구":
				model.addAttribute("gu07", mainDataResponseDto);
				break;
			case "동대문구":
				model.addAttribute("gu08", mainDataResponseDto);
				break;
			case "중구":
				model.addAttribute("gu09", mainDataResponseDto);
				break;
			case "성동구":
				model.addAttribute("gu10", mainDataResponseDto);
				break;	
			case "마포구":
				model.addAttribute("gu11", mainDataResponseDto);
				break;		
			case "중량구":
				model.addAttribute("gu12", mainDataResponseDto);
				break;		
			case "강서구":
				model.addAttribute("gu13", mainDataResponseDto);
				break;		
			case "광진구":
				model.addAttribute("gu14", mainDataResponseDto);
				break;		
			case "양천구":
				model.addAttribute("gu15", mainDataResponseDto);
				break;		
			case "구로구":
				model.addAttribute("gu16", mainDataResponseDto);
				break;		
			case "영등포구":
				model.addAttribute("gu17", mainDataResponseDto);
				break;		
			case "용산구":
				model.addAttribute("gu18", mainDataResponseDto);
				break;		
			case "강남구":
				model.addAttribute("gu19", mainDataResponseDto);
				break;		
			case "강동구":
				model.addAttribute("gu20", mainDataResponseDto);
				break;		
			case "금천구":
				model.addAttribute("gu21", mainDataResponseDto);
				break;	
			case "관악구":
				model.addAttribute("gu22", mainDataResponseDto);
				break;						
			case "동작구":
				model.addAttribute("gu23", mainDataResponseDto);
				break;						
			case "서초구":
				model.addAttribute("gu24", mainDataResponseDto);
				break;						
			case "송파구":
				model.addAttribute("gu25", mainDataResponseDto);
				break;						

			}
		}
		
    	return "main/seoul";
    }
    
    @GetMapping("/apt")
    public String mainApt(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
		MainDataResponseDto mainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
		model.addAttribute("centerdata", mainCenterDataResponseDto);
		
    	return "main/apt";
    }
    
    @GetMapping("/location")
    public String mainLocation(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
   		MainDataResponseDto mainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", mainCenterDataResponseDto);
   		
   		maindataSearchRequestDto.setDayflag(mainCenterDataResponseDto.getDayflag());
		maindataSearchRequestDto.setTablename("location");
		
		List<MainDataResponseDto> mainDataResponseDtoList = maindataService.getMainDataTable(maindataSearchRequestDto);
		
		for(MainDataResponseDto mainDataResponseDto : mainDataResponseDtoList) {
			switch (mainDataResponseDto.getLocation()) {
			case "압구정라이프미성2차":
				model.addAttribute("apt01", mainDataResponseDto);
				break;
			case "압구정신현대아파트":
				model.addAttribute("apt02", mainDataResponseDto);
				break;
			case "압구정한양6차아파트":
				model.addAttribute("apt03", mainDataResponseDto);
				break;
			case "청담아이파크":
				model.addAttribute("apt04", mainDataResponseDto);
				break;
			case "청담우성아파트":
				model.addAttribute("apt05", mainDataResponseDto);
				break;
			case "청담e편한세상":
				model.addAttribute("apt06", mainDataResponseDto);
				break;
			case "논현동현아파트":
				model.addAttribute("apt07", mainDataResponseDto);
				break;
			case "논현두산위브":
				model.addAttribute("apt08", mainDataResponseDto);
				break;
			case "논현2아펠비움":
				model.addAttribute("apt09", mainDataResponseDto);
				break;
			case "논현월드메르디앙":
				model.addAttribute("apt10", mainDataResponseDto);
				break;	
			case "삼성동센트럴아이파크":
				model.addAttribute("apt11", mainDataResponseDto);
				break;		
			case "역삼레미안아파트":
				model.addAttribute("apt12", mainDataResponseDto);
				break;		
			case "레미안대치팰리스1단지":
				model.addAttribute("apt13", mainDataResponseDto);
				break;		
			case "도곡렉슬아파트":
				model.addAttribute("apt14", mainDataResponseDto);
				break;		
			case "도곡현대아이파크1차":
				model.addAttribute("apt15", mainDataResponseDto);
				break;		
			case "역삼e편한세상아파트":
				model.addAttribute("apt16", mainDataResponseDto);
				break;		
			case "GS개포자이아파트":
				model.addAttribute("apt17", mainDataResponseDto);
				break;		
			case "래미안루체하임아파트":
				model.addAttribute("apt18", mainDataResponseDto);
				break;		
			case "수서목련타운아파트":
				model.addAttribute("apt19", mainDataResponseDto);
				break;		
			case "래미안블레스티지":
				model.addAttribute("apt20", mainDataResponseDto);
				break;		
			}
		}
   		
    	return "main/location";
    }
    
    @GetMapping("/customer")
    public String customer(Model model, MaindataSearchRequestDto maindataSearchRequestDto, CustomerSearchRequestDto customerSearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    	
   		MainDataResponseDto mainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", mainCenterDataResponseDto);
    	
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
   		MainDataResponseDto mainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", mainCenterDataResponseDto);
   		
    	return "trade/trade";
    }
    
    @GetMapping("/analysis")
    public String analysis(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
    	MainDataResponseDto mainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", mainCenterDataResponseDto);
   		
    	return "analysis/analysis";
    }
    
    @GetMapping("/reservation")
    public String reservation(Model model, MaindataSearchRequestDto maindataSearchRequestDto) {
    	MainDataResponseDto mainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", mainCenterDataResponseDto);
   		
    	return "reservation/reservation";
    }
    
    @GetMapping("/environment")
    public String environment(Model model, MaindataSearchRequestDto maindataSearchRequestDto, UserinfoSearchRequestDto userinfoSearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    
   		MainDataResponseDto mainCenterDataResponseDto = maindataService.getMainCenterData(maindataSearchRequestDto);
   		model.addAttribute("centerdata", mainCenterDataResponseDto);
   		
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
