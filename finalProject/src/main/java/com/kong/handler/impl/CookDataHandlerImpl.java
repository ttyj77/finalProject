package com.kong.handler.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kong.dao.CookDao;
import com.kong.entity.CookEntity;
import com.kong.handler.CookDataHandler;

@Service
@Transactional
public class CookDataHandlerImpl implements CookDataHandler {

	CookDao cookDao;
	
	@Autowired
	public CookDataHandlerImpl(CookDao cookDao) {
		this.cookDao = cookDao;
	}
	
	@Override
	public CookEntity saveCookEntity(String id,String name, int company_code, String how_to_make,String link) {
		CookEntity cookEntity = new CookEntity(id, name,company_code,how_to_make,link);
		
		return cookDao.saveCook(cookEntity);
	}
	
	@Override
	public CookEntity getCookEntity(String id) {
		return cookDao.getCook(id);
	}
	
	@Override
	public CookEntity getCookNameEntity(String name) {
		return cookDao.getCookName(name);
	}
}
