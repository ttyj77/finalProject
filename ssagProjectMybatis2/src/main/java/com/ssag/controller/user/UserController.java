package com.ssag.controller.user;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssag.model.UserVo;
import com.ssag.service.UserService;

@Controller("userController")
//@RestController

public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserVo userVo;
	
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;


	@GetMapping("/index")
	public String index() {
		return "home";
	}
	
	@GetMapping("/users")
	public String createUser() {
		System.out.println("여기는 GET Mapping Users");
		return "register";
	}

	
	
	@PostMapping("/users")
	public String addUser(Model model, @RequestParam(value="id") String id,
	@RequestParam(value="address") String address, @RequestParam(value="password") String password,
	 @RequestParam(value="email") String email, @RequestParam(value="name") String name, @RequestParam(value="telephone") String telephone, @RequestParam(value="role") String role) {
		// 소스는 사용자 정보가 담긴 accountDto 객체가 담긴 정보를 entity에 옮겨야 한다.

		userVo.setId(id);
		userVo.setPassword(password);
		userVo.setAddress(address);
		
		userVo.setEmail(email);
		userVo.setName(name);
		userVo.setTelephone(telephone);
		userVo.setRole(role);
//		userVo.setBirth(birth);
		
		userService.addUser(userVo);
		
		System.out.println("USerVo =========================================" + userVo.getAddress());
		
		return "redirect:/";
	}

	
	
}
