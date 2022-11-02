package com.ssag.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssag.dao.FridgeDao;
import com.ssag.model.FridgeBoxVo;
import com.ssag.model.FridgeVo;
import com.ssag.model.IngredientVo;
import com.ssag.model.UserVo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FridgeService{

	@Resource
	private FridgeDao fridgeDao;

	@Autowired
	public FridgeService(FridgeDao fridgeDao) {
		this.fridgeDao = fridgeDao;
	}

	@Transactional
	public void createFridgeBox(FridgeBoxVo fridgeBoxVo) {
		System.out.println("fridgeService 진입 !! ==========================:  ");
		fridgeDao.insertItem(fridgeBoxVo);
		System.out.println("fridgeDao==========================:  " + fridgeDao);
	}

	@Transactional
	public List<IngredientVo> ingredientAll(){
		System.out.println("여기는 FridgeService");
		List<IngredientVo> ingredientList = fridgeDao.ingredientAll();
		
		ArrayList<IngredientVo> ingredientList2 = new ArrayList<IngredientVo>();
		for (int i = 0; i < ingredientList.size(); i++) {
			ingredientList2.add(ingredientList.get(i));
		}
		return ingredientList2;
	} 
	
	@Transactional
	public List<String> myFridgeBox(FridgeVo fridgeVo) {
		System.out.println("fridgeService MyfridgeBox!!!");
		List<FridgeVo> fridgeInfo = fridgeDao.myfridgeBox();
		List<String> fridgeInfoName = new ArrayList<String>();
		fridgeInfoName.add(fridgeInfo.get(1).getName());
		return fridgeInfoName;
		
	}
	
	public void addFridge(FridgeVo fiFridgeVo) {
		fridgeDao.insertFridge(fiFridgeVo);
		System.out.println("FridgeService AddFridge 진입");
	}

//	public List<> myFridgeList(UserVo userVo, FridgeVo fridgeVo)
	
	
}
