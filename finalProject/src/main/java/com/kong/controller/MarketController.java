package com.kong.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kong.dto.CookDto;
import com.kong.dto.MerchandiseDto;
import com.kong.service.MarketService;

@RestController
@Controller("marketController")
@RequestMapping("/market")
public class MarketController {

	private MarketService cookService;
	
	@Autowired
	public MarketController(MarketService cookService) {
		this.cookService = cookService;
	}

	@RequestMapping(value = "/index")
	public String indexList() {
		return "index";
	}
	
	@GetMapping(value="/cook/{id}")
	public CookDto getCook(@PathVariable String id) {
		return cookService.getCook(id);
	}
	
//	@GetMapping(value="/cook3/{item_name}")
//	public MerchandiseDto getItemName(@PathVariable String item_name) {
//		return cookService.getItemName(item_name);
//	}
	
	@GetMapping(value="/cook3/{link}")
	public MerchandiseDto getItemLink(@PathVariable String link) {
		return cookService.getItemLink(link);
	}
	
	@PostMapping(value = "/cook")
	public CookDto createCook(@RequestBody CookDto cookDto) {
		
		String id = cookDto.getId();
		String name = cookDto.getName();
		int company_code = cookDto.getCompany_code();
		String how_to_make = cookDto.getHow_to_make();
		String link = cookDto.getLink();
		
		return cookService.saveCook(id, name, company_code, how_to_make, link);
	}
	
//	@GetMapping(value = "/cook2")
//	public CookDto createCook2(@RequestBody CookDto cookDto) {
//		
//		String id = cookDto.getId();
//		String name = cookDto.getName();
//		int company_code = cookDto.getCompany_code();
//		String how_to_make = cookDto.getHow_to_make();
//		String link = cookDto.getLink();
//		
//		return cookService.listCook(id, name, company_code, how_to_make, link);
//	}
	
	@GetMapping(value="/hello")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		param.entrySet().forEach(map ->{
			sb.append(map.getKey()+ ":" + map.getValue()+"\n");
		});
		return sb.toString();
	}
	
	@PostMapping(value="/post")
	public String postMember(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		
		postData.entrySet().forEach(map-> {
			sb.append(map.getKey() + ":" +map.getValue()+"/n");
		});
		return sb.toString();
	}
	
	@GetMapping(value="/cook1/{name}")
	public CookDto getName(@PathVariable String name) {
		return cookService.getName(name);
	}
	
	
}
