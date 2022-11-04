package com.ssag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
 
	
	@GetMapping(value="/")
	public String home() throws Exception{
//		System.out.println("LoginUserBean!!"+loginUserBean);
		return "index";
	}
	

	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
}
