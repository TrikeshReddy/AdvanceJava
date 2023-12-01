package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String redirect() {
		return "viewpage";
	}

	@RequestMapping("/helloagain")
	public String display(HttpServletRequest request) {
		
		return "final";
	}
	
	@RequestMapping(value="/firstacion" , method = RequestMethod.POST)
	public String firstAction(@RequestParam("uname") String uname,@RequestParam("pwd") String pwd) {
		if(uname=="Trikesh" && pwd=="pwd")
		 return "success";
		else
			return "failure";
		
	}
	@PostMapping(value="/secondaction")
	public String secondAction(@RequestBody Credentials credentials) {
		System.out.println(credentials.getFirstName());
		System.out.println(credentials.getPwd());
		return "success";
		
	}
	

}
