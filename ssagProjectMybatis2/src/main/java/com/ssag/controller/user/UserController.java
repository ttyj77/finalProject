package com.ssag.controller.user;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
		return "register";
	}

	@PostMapping("/users")
	public String addUser(UserVo userVo, HttpServletRequest request,HttpSession session) {
		// 소스는 사용자 정보가 담긴 accountDto 객체가 담긴 정보를 entity에 옮겨야 한다.
		userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
		userService.addUser(userVo);
		
		System.out.println("USerVo22 =========================================" + userVo.getAddress());
		return "redirect:/";
	}

	@GetMapping("/session")
	public String hello(HttpSession session, Principal principal) {
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		System.out.println("세션에 저장된 id : " + id);
		System.out.println("세션에 저장된 name : " + name);
		String username = principal.getName();
		System.out.println("SEssion Username : " + username);
		return "redirect:/";
	}
	
	
	@GetMapping("/index222")
	public void index(Authentication authentication) {
	    UserDetails userDetails = (UserDetails)authentication.getPrincipal();
	    System.out.println("Controller Userdetails username = " + userDetails.getUsername());
//	    System.out.println("role = " + userDetails.getAuthorities().stream().map(r -> String.valueOf(r)).collect(Collectors.joining(",")));
	}
	
}
