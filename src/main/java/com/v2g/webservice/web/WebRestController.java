package com.v2g.webservice.web;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.v2g.webservice.dto.environment.userinfo.UserinfoSaveRequestDto;
import com.v2g.webservice.service.environment.UserinfoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private Environment env;
	private UserinfoService userinfoService;
	
	@GetMapping("/hello")
	public String hello() {
	    return "Hello V2G";
	}
	
	@GetMapping("/profile")
	public String getProfile () {
	    return Arrays.stream(env.getActiveProfiles())
	            .findFirst()
	            .orElse("");
	}
	
	@PostMapping("/environment/userlogin")
    public long userlogin(HttpServletRequest request,@RequestBody UserinfoSaveRequestDto dto){
    	HttpSession httpSession = request.getSession(true);
    	System.out.println("dto : " + dto.getUserid());
    	long rstCnt = userinfoService.getUserinfo(dto.getUserid(),dto.getUserpass());
    	if(rstCnt > 0) {
    		 
    		 httpSession.setAttribute("USEID", dto.getUserid());
    	}
    	System.out.println("rstCnt : " + rstCnt);
    	System.out.println("httpSession USEID : " + httpSession.getAttribute("USEID"));
    	return rstCnt;
    }
	
    @PostMapping("/environment/userlogout")
    public long userlogout(HttpServletRequest request){
    	HttpSession httpSession = request.getSession(true);
    	httpSession.setAttribute("USEID", "");
    	httpSession.invalidate();
    	return 0;
    }
    
	
}
