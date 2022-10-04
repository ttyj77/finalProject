package com.kong.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kong.dto.CookDto;
import com.kong.entity.CookEntity;
import com.kong.handler.CookDataHandler;
import com.kong.service.CookService;

@Service
public class CookServiceImpl implements CookService{
	
//	private final Logger LOGGER = LoggerFactory.getLogger(CookServiceImpl.class);
//	private final CookRepository cookRepository;
	
	CookDataHandler cookDataHandler;
	
	@Autowired
	public CookServiceImpl(CookDataHandler cookDataHandler) {
		this.cookDataHandler = cookDataHandler;
	}
	
	@Override
	public CookDto saveCook(String id,String name, int company_code, String how_to_make,String link) {
		CookEntity cookEntity = cookDataHandler.saveCookEntity(id, name, company_code, how_to_make, link);
		
		CookDto cookDto = new CookDto(cookEntity.getId(), cookEntity.getName(),cookEntity.getCompany_code(),cookEntity.getHow_to_make(),cookEntity.getLink());
		return cookDto;
	}
	
	@Override
	public CookDto getCook(String id) {
		CookEntity cookEntity = cookDataHandler.getCookEntity(id);
		
		CookDto cookDto = new CookDto(cookEntity.getId(), cookEntity.getName(),cookEntity.getCompany_code(),cookEntity.getHow_to_make(),cookEntity.getLink());
		return cookDto;
	}
	
	@Override
	public CookDto getCookName(String name) {
		CookEntity cookEntity = cookDataHandler.getCookEntity(name);
		CookDto cookDto = new CookDto(cookEntity.getId(), cookEntity.getName(),cookEntity.getCompany_code(),cookEntity.getHow_to_make(),cookEntity.getLink());
		return cookDto;
	}
	
}
