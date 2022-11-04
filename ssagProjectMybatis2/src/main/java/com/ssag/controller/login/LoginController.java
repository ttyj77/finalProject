package com.ssag.controller.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssag.model.UserVo;
import com.ssag.sercurity.service.AccountContext;
import com.ssag.sercurity.service.CustomUserDetailsSercive;
import com.ssag.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserVo userVo;
	@Autowired
	CustomUserDetailsSercive customUserDetailsSercive;
 
	@Autowired
	UserService userService;


	
	@GetMapping("/login")
	public String login(HttpServletRequest request, Model model) {

		return "login";
	}

	// 세션 저장 (세션 ID, 사용자 정보)
//	// 세션은 브라우저 당 1개 생성(시크릿 모드도 동일, 같은 브라우저에서 새탭 or 새창 띄워도 로그인 유지) / 쿠키는 시크릿 모드시 없어짐
	@PostMapping("/login")
	public HttpSession login(HttpSession session, HttpServletRequest request, String username, String password,UserVo userVo) {

		session = request.getSession(false);
		session.setAttribute("username", userVo.getId());
		session.setAttribute("userAddress", userVo.getAddress());
		String sessionId = session.getId();
		System.out.println("이건 Controller 의 session : " + session);
		
		return session;

	}

	// 인증을 받은 사용자가 로그아웃가능 로그아웃은 SecurityContextLogoutHandler이친구가 진행함
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// authentication 이 널이 아니면 로그아웃진행
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login";
	}
	
	
	@GetMapping("/afterLogin")
	public String afterLogin() {
		
		return "afterlogin";
	}

	@GetMapping(value = "/denied")
	public String accessDenied(UserVo userVo, CustomUserDetailsSercive detailsSercive, String username, HttpSession session,Model model)
			throws Exception {
		
		String id = (String) session.getAttribute("username");
		String address = (String) session.getAttribute("userAddress");
		System.out.println("ID가 없나???: " + id);
		System.out.println("ID가 없나???222: " + address);
		userVo = userService.findById(id);
		model.addAttribute("member", userVo);
		String sessionId = session.getId();
		long sesstionTime = session.getCreationTime();
		boolean sessionNew = session.isNew();
		System.out.println(sessionId);
		System.out.println(sesstionTime);
		System.out.println(sessionNew);
		System.out.println(model);
		return null;

	}

}
