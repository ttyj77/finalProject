package com.kong.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kong.dao.CookDao;
import com.kong.entity.CookEntity;
import com.kong.repository.CookRepository;

@Service
public class CookDaoImpl implements CookDao{
	
	CookRepository cookRepository;
	
	@Autowired
	public CookDaoImpl(CookRepository cookRepository) {
		this.cookRepository = cookRepository;
	}

	@Override
	public CookEntity saveCook(CookEntity cookEntity) {
		cookRepository.save(cookEntity);
		return cookEntity;
	}
	
	@Override
	public CookEntity getCook(String id) {
		CookEntity cookEntity = cookRepository.getById(id);
		return cookEntity;
		
	}
	@Override
	public CookEntity getCookName(String name) {
		CookEntity cookEntity = cookRepository.getById(name);
		return cookEntity;
	}
}
