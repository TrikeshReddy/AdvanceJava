package com.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@RequestMapping("/home")
	public String firstMethod(){
		System.out.println("hello this method");
		return "first";
	}
}
