package com.ssag.controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssag.model.UserVo;
import com.ssag.sercurity.service.CustomUserDetailsSercive;

@Controller
public class LoginController {

	@Autowired
	UserVo userVo;
	@Autowired
	CustomUserDetailsSercive customUserDetailsSercive;

	@GetMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String username = (String) request.getSession().getAttribute("username");
		model.addAttribute("username", username);
		return "login";
	}

	// 세션 저장 (세션 ID, 사용자 정보)
	// 세션은 브라우저 당 1개 생성(시크릿 모드도 동일, 같은 브라우저에서 새탭 or 새창 띄워도 로그인 유지) / 쿠키는 시크릿 모드시 없어짐
	@PostMapping("/login")
	public String login(UserVo userVo, Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {

		request.getSession().setAttribute("username", userVo.getId());
		// 쿠키 전달 (세션 ID)
		response.addCookie(new Cookie("AUTH", request.getSession().getId()) {
			{
				setMaxAge(60);
				setPath("/");
			}
		});

		model.addAttribute("username", userVo.getId());

		System.out.println("controller session : " + model);
		return null;
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

	@GetMapping(value = "/denied")
	public String accessDenied(CustomUserDetailsSercive detailsSercive, String id) throws Exception {
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (principal instanceof UserDetails) {
//			  String username = ((UserDetails)principal).getUsername();
//			} else {
//			  String username = principal.toString();
//			}
		
		UserDetails username = detailsSercive.loadUserByUsername(id);
		
//		System.out.println("USErName : " + authentication.getName());
		System.out.println(username);
		return "home";
	}

}
