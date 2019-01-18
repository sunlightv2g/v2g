package com.v2g.webservice.web;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private Environment env;
	
    @GetMapping("/")
    public String main(Model model) {
    	//model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
	
	
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
}
