package com.kong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kong.dto.CookDto;
import com.kong.dto.MerchandiseDto;
import com.kong.entity.CookEntity;
import com.kong.entity.MerchandiseEntity;
import com.kong.handler.MarketDataHandler;
import com.kong.service.MarketService;

@Service
public class MarketServiceImpl implements MarketService {

//	private final Logger LOGGER = LoggerFactory.getLogger(CookServiceImpl.class);
//	private final CookRepository cookRepository;

	MarketDataHandler cookDataHandler;

	@Autowired
	public MarketServiceImpl(MarketDataHandler cookDataHandler) {
		this.cookDataHandler = cookDataHandler;
	}

	@Override
	public CookDto saveCook(String id, String name, int company_code, String how_to_make, String link) {
		CookEntity cookEntity = cookDataHandler.saveCookEntity(id, name, company_code, how_to_make, link);

		CookDto cookDto = new CookDto(cookEntity.getId(), cookEntity.getName(), cookEntity.getCompany_code(),
				cookEntity.getHow_to_make(), cookEntity.getLink());
		return cookDto;
	}

	@Override
	public CookDto getCook(String id) {
		CookEntity cookEntity = cookDataHandler.getCookEntity(id);

		CookDto cookDto = new CookDto(cookEntity.getId(), cookEntity.getName(), cookEntity.getCompany_code(),
				cookEntity.getHow_to_make(), cookEntity.getLink());
		return cookDto;
	}
	
	@Override
	public CookDto getName(String name) {
		CookEntity cookEntity = cookDataHandler.getNameEntity(name);

		CookDto cookDto = new CookDto(cookEntity.getId(), cookEntity.getName(), cookEntity.getCompany_code(),
				cookEntity.getHow_to_make(), cookEntity.getLink());
		return cookDto;
	}
	
//	@Override
//	public MerchandiseDto getItemName(String item_name) {
//		Merchandise merchandise = cookDataHandler.getItemNameEntity(item_name);
//		
//		MerchandiseDto merchandiseDto = new MerchandiseDto(merchandise.getCode(),merchandise.getCompany_code(),merchandise.getItem_name(),
//				merchandise.getCost(),merchandise.getOut_of_stock(),merchandise.getLink(),merchandise.getImg_link());
//		return merchandiseDto;
//	}
	
	@Override
	public MerchandiseDto getItemLink(String link) {
		MerchandiseEntity merchandise = cookDataHandler.getItemLinkEntity(link);
		
		MerchandiseDto merchandiseDto = new MerchandiseDto(merchandise.getCode(),merchandise.getCompany_code(),merchandise.getItem_name(),
				merchandise.getCost(),merchandise.getOut_of_stock(),merchandise.getLink(),merchandise.getImg_link());
		return merchandiseDto;
	}
	
}
