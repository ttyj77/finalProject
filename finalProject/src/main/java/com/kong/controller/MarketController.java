package com.kong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kong.dto.CookDto;
import com.kong.entity.CookEntity;
import com.kong.service.CookService;

@RestController
@Controller("marketController")
@RequestMapping("/market")
public class MarketController {

	private CookService cookService;
	
	@Autowired
	public MarketController(CookService cookService) {
		this.cookService = cookService;
	}

	

	
	@RequestMapping(value = "/index")
	public String indexList() {
		return "index";
	}
	
	@GetMapping(value="/cook/{cook_id}")
	public CookDto getCook(@PathVariable String cook_id) {
		return cookService.getCook(cook_id);
	}
	
	@PostMapping(value = "/cook")
	public CookDto createCook(@RequestBody CookDto cookDto) {
		
		String cook_id = cookDto.getCook_id();
		String name = cookDto.getName();
		int company_code = cookDto.getCompany_code();
		String how_to_make = cookDto.getHow_to_make();
		String link = cookDto.getLink();
		
		return cookService.saveCook(cook_id, name, company_code, how_to_make, link);
	}
	
}
