package com.kong.dao;

import com.kong.entity.CookEntity;

public interface CookDao {

	CookEntity saveCook(CookEntity cookEntity);
	
	CookEntity getCook(String id);
	CookEntity getCookName(String name);
}

