package com.ssag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
 
	
	@GetMapping(value="/")
	public String home2() throws Exception{
//		System.out.println("LoginUserBean!!"+loginUserBean);
		return "home";
	}
	

}
