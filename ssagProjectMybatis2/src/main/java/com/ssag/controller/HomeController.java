package com.ssag.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssag.model.UserVo;

@Controller
public class HomeController {
 
	
	@GetMapping(value="/home")
	public String home() throws Exception{
		System.out.println("LoginUserBean!!"+loginUserBean);
		return "home";
	}
	

}
