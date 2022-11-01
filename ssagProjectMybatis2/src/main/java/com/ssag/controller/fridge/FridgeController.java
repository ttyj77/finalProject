package com.ssag.controller.fridge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssag.model.FridgeBoxVo;
import com.ssag.model.IngredientVo;
import com.ssag.service.FridgeService;

@Controller
public class FridgeController {

	@Autowired
	private FridgeService fridgeService;

	@Autowired
	private FridgeBoxVo fridgeBoxVo;

	@Autowired
	private IngredientVo ingredientVo;

	ModelAndView mv;

	List<IngredientVo> ingredientList = new ArrayList<IngredientVo>();
	Map<Integer, String> result = new HashMap<>();

	@PostMapping("/fridgeBox")
	public String createFridgeBox(FridgeBoxVo fridgeBoxVo) {
		// 소스는 사용자 정보가 담긴 accountDto 객체가 담긴 정보를 entity에 옮겨야 한다.
		System.out.println("FridgeController fridgeBox.getQuantity" + fridgeBoxVo.getQuantity());
		fridgeBoxVo.setStoragecode(123);
		fridgeBoxVo.setCreateddate(LocalDate.now());
		fridgeBoxVo.setFridgecode(5);
		fridgeService.createFridgeBox(fridgeBoxVo);
		return "redirect:/";
	}

	@GetMapping("/fridgeBox")
	public String writeArticle(Model model) {
//		List<String> ingredientList3 = fridgeService.ingredientAll();
//
//		model.addAttribute(ingredientList3);
//		model.addAttribute("ingredientList3", ingredientList3);
		return "user/fridge/index";
	}

	@PostMapping(value = "/ingredientList")
//	@ResponseBody
	public String ingredientAll() {
		System.out.println(ingredientVo.getName());
		return "redirect:/";
	}

	@GetMapping(value = "/ingredientList")
	public String ingredientAll2(Model model) {
//		String name = fridgeService.ingredientAll().get(0).getName();
		List<String> ingredientList3 = fridgeService.ingredientAll();
		
//		model.addAttribute(name);
		model.addAttribute("ingredientList3", ingredientList3);
		return "user/fridge/exe";
	}

//	@GetMapping(value = "/ingredientList")
//	@ResponseBody
//	public String ingredientAll2(IngredientVo ingredientVo) {
////		String ingredientList2 = result.put(ingredientVo.getCode(), ingredientVo.getName());
//		result = fridgeService.testService(ingredientVo.getCode(), ingredientVo.getName());
//		System.out.println(ingredientList2);
//		return ingredientList2;
//	}

//	@GetMapping("/ingredientList")
//	public List<Map<String, Object>> ingredientAll2() {
//		List<Map<String,Object>> result = fridgeService.ingredientAll();
//		String data = result.get(0).get("name").toString();
//		System.out.println(data);
//		return result;
//	}

}
