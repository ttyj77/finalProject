package com.ssag.controller.fridge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssag.model.FridgeBoxVo;
import com.ssag.model.IngredientVo;
import com.ssag.model.UserVo;
import com.ssag.service.FridgeService;
import com.ssag.service.UserService;

@Controller
public class FridgeController {

	@Autowired
	private FridgeService fridgeService;

	@Autowired
	private UserService userService;

	@Autowired
	private FridgeBoxVo fridgeBoxVo;

	@Autowired
	private IngredientVo ingredientVo;

	ModelAndView mv;

	List<IngredientVo> ingredientList = new ArrayList<IngredientVo>();
	Map<Integer, String> result = new HashMap<>();

	@PostMapping("/fridgeBox")
	public String createFridgeBox(FridgeBoxVo fridgeBoxVo, IngredientVo ingredientVo) {
		// 소스는 사용자 정보가 담긴 accountDto 객체가 담긴 정보를 entity에 옮겨야 한다.
//		System.out.println("FridgeController fridgeBox.getQuantity" + fridgeBoxVo.getQuantity());
//		System.out.println("FridgeController ingredient.name : " + ingredientVo.getName());
//		System.out.println("FridgeController ingredient.Code : " + ingredientVo.getCode());
		fridgeBoxVo.setIngredientcode(ingredientVo.getCode());
		fridgeBoxVo.setStoragecode(1);
		System.out
				.println("=====================================setIngredientcode : " + fridgeBoxVo.getIngredientcode());
		fridgeBoxVo.setCreateddate(LocalDate.now());
		fridgeBoxVo.setFridgecode(5);
		fridgeService.createFridgeBox(fridgeBoxVo);
		return "redirect:/";
	}

	@GetMapping("/fridgeBox")
	public String writeArticle(UserVo userVo, Model model, HttpServletRequest request) {
		System.out.println("여기는 controller : fridgeBox ");
		List<IngredientVo> ingredientList3 = fridgeService.ingredientAll();
//		model.addAttribute(ingredientList3);
		model.addAttribute("ingredientList3", ingredientList3);
		String username = (String) request.getSession().getAttribute("username");
		model.addAttribute("username", userVo.getId());
		
		System.out.println(userVo.getId());
		return "user/fridge/index";
	}

//	@GetMapping("/myFridgeBox")
//	public String myFridgeBox(Model model) {
//		System.out.println("여기는 controller : MyfridgeBox");
//		
//		List<String> result = fridgeService.myFridgeBox(fridgeVo); 
//		
//		return "user/fridge/myFridgeBox";
//}

	@PostMapping("/myFridgeBox")
	public String addFridge() {
		System.out.println("Fridge Contrller MyFridgeBox 진입!!!");
		return "redirect:/";
	}

//	@GetMapping("/testId")
//	@ResponseBody
//	public String UserName(CustomUserDetailsSercive userDetailsSercive) {
////		String username = accountContext.getUsername();
////		System.out.println("여기는 AccountContext Controller : " + accountContext);
////		System.out.println("여기는 AccountContext Principal : " + principal);
////		ArrayList<String> username = new ArrayList<>();
////		
////		username.add(principal.getName());
////		System.out.println("1.Name : " + principal.getName());
////		System.out.println("2.Class : " + principal.getClass());
////		System.out.println("3.UserName Size: " + username.getClass().getName());
//////		String username2 = accountContext.getUserVo().getId();
////		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////		CustomUserDetailsSercive userDetails =(CustomUserDetailsSercive)principal;
////		System.out.println("만든 Principal : " + userDetails);
//		
//		return "hello";
//	}
//	
//	
//	@GetMapping("/test")
//	public String test(@AuthenticationPrincipal Authentication authentication, ModelMap map) {
//		System.out.println("여기는 들어오나?");
//		AccountContext accountContext = (AccountContext) authentication.getPrincipal();
//		System.out.println("여기는 들어오나?22"+ accountContext);
//		map.addAttribute("user", accountContext);
//		System.out.println("AccountContext : " + accountContext.getUserVo().getId());
//		
//		return"main";
//	}

//	@GetMapping("/test")
//	public String test(UserVo userVo, HttpServletResponse response, HttpSession session,HttpServletRequest request) {
//	
//		session = request.getSession();
//		String id = (String)session.getAttribute("id");
//		System.out.println("세션에 저장된 id : " + id);
//
//		
//		return null;
//		
//	}

}
