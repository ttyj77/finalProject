package com.ssag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssag.dao.UserDao;
import com.ssag.model.UserVo;
import com.ssag.service.UserService;

import lombok.RequiredArgsConstructor;

//@RestController
//@RequestMapping("api/v1")
@RequiredArgsConstructor
@Controller
public class RestApiController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/home")
	@ResponseBody
	public String home() {
		return "<h1>home</h1>";
	}
	
	@PostMapping("token")
	public String token() {
		return "<h1>token</h1>";
	}
	
	@PostMapping("/join")
	public String addUser(UserVo userVo) {
		// 소스는 사용자 정보가 담긴 accountDto 객체가 담긴 정보를 entity에 옮겨야 한다.
		userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
		userVo.setRole("ROLE_USER");
		userService.addUser(userVo);
		
		System.out.println("USerVo22 =========================================" + userVo.getUsername());
		return "redirect:/";
	}
	
	
	@GetMapping("/join")
	public String createUser() {
		System.out.println("여기는 GET Mapping Users");
		return "register";
	}

}
