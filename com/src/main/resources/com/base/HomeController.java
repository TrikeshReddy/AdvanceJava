package com.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@RequestMapping("/home")
	public String firstMethod(){
		
		return "viewpage";
	}
	@RequestMapping("/hello")
	public String firstMethod(){
		
		return "index";
	}
}
