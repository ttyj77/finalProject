package com.kong.service;

import com.kong.dto.CookDto;

public interface CookService {

	CookDto saveCook(String cook_id,String name, int company_code, String how_to_make,String link);
	
	CookDto getCook(String cook_id);
	
	CookDto getCookName(String name);
	
}
