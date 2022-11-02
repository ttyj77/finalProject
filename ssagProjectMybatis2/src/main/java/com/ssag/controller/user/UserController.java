package com.ssag.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssag.model.UserVo;
import com.ssag.service.UserService;


@Controller("userController")
//@RestController

public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserVo userVo;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@GetMapping("/index")
	public String index() {
		return "home";
	}
	
	@GetMapping("/users")
	public String createUser() {
		System.out.println("여기는 GET Mapping Users");
		return "user/login/register";
	}


	
	@PostMapping("/users")
	public String addUser(UserVo userVo) {
		// 소스는 사용자 정보가 담긴 accountDto 객체가 담긴 정보를 entity에 옮겨야 한다.
		userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
		userService.addUser(userVo);
		System.out.println("USerVo22 =========================================" + userVo.getAddress());
		return "redirect:/";
	}
	
}
