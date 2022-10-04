package com.kong.handler;

import com.kong.entity.CookEntity;

public interface CookDataHandler {

	CookEntity saveCookEntity(String cook_id,String name, int company_code, String how_to_make,String link);
	
	CookEntity getCookEntity(String cook_id);
	
}
