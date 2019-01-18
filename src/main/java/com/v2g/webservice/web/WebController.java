package com.v2g.webservice.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.v2g.webservice.dto.environment.userinfo.UserinfoMainResponseDto;
import com.v2g.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;
import com.v2g.webservice.service.environment.UserinfoService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private UserinfoService userinfoService;
	
    @GetMapping("/")
    public String main(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
        //return "main";
    	return "redirect:/main";
    }
	
    @GetMapping("/main")
    public String mainMain(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
        //return "main";
    	return "main/main";
    }
    
    @GetMapping("/seoul")
    public String mainSeoul(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
    	//return "main";
    	return "main/seoul";
    }
    
    @GetMapping("/apt")
    public String mainApt(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
    	//return "main";
    	return "main/apt";
    }
    
    @GetMapping("/location")
    public String mainLocation(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
    	//return "main";
    	return "main/location";
    }
    
    @GetMapping("/customer")
    public String customer(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
    	//return "main";
    	return "customer/customer";
    }
    
    @GetMapping("/trade")
    public String trade(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
    	//return "main";
    	return "trade/trade";
    }
    
    @GetMapping("/analysis")
    public String analysis(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
    	//return "main";
    	return "analysis/analysis";
    }
    
    @GetMapping("/reservation")
    public String reservation(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
    	//return "main";
    	return "reservation/reservation";
    }
    
    @GetMapping("/environment")
    public String environment(Model model, UserinfoSearchRequestDto userinfoSearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    	    	
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
