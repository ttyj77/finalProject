package com.kong.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kong.dao.MarketDao;
import com.kong.entity.CookEntity;
import com.kong.entity.MerchandiseEntity;
import com.kong.repository.CookRepository;
import com.kong.repository.MerchandiseRepository;

@Service
public class MarketDaoImpl implements MarketDao{
	
	CookRepository cookRepository;
	MerchandiseRepository merchandiseRepository;
	
	@Autowired(required = true)
	public MarketDaoImpl(CookRepository cookRepository, MerchandiseRepository merchandiseRepository) {
		this.cookRepository = cookRepository;
		this.merchandiseRepository = merchandiseRepository;
	}
	
//	@Autowired(required = true)
//	public CookDaoImpl(MerchandiseRepository merchandiseRepository) {
//		this.merchandiseRepository = merchandiseRepository;
//	}

	
	@Override
	public CookEntity saveCook(CookEntity cookEntity) {
		cookRepository.save(cookEntity);
		return cookEntity;
	}
	

	@Override
	public CookEntity getCook(String id) {
		CookEntity cookEntity = cookRepository.getReferenceById(id);
		return cookEntity;
	}
	
	@Override
	public CookEntity getName(String name) {
		CookEntity cookEntity = cookRepository.findByName(name);
		return cookEntity;
	}
	
//	@Override
//	public Merchandise getItemName(String item_name) {
//		Merchandise merchandise = merchandiseRepository.findByItem_nameContaining(item_name);
//		return merchandise;
//	}
	
	@Override
	public MerchandiseEntity getItemLink(String link) {
		MerchandiseEntity merchandise = merchandiseRepository.findByLinkContaining(link);
		return merchandise;
	}


}
