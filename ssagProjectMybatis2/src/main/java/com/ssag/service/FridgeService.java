package com.ssag.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssag.dao.FridgeDao;
import com.ssag.model.FridgeBoxVo;
import com.ssag.model.IngredientVo;

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

	
	
	
	public List<String> ingredientAll(){
		System.out.println("여기는 FridgeService");
		List<IngredientVo> ingredientList = fridgeDao.ingredientAll();
//		List<String> name = new ArrayList<String>();
//		System.out.println("IngredientList Service" + ingredientList);
		ArrayList<String> ingredientList2 = new ArrayList<String>();
		for (int i = 0; i < ingredientList.size(); i++) {
//			ingredientList2.add(ingredientList.get(i));
			ingredientList2.add(ingredientList.get(i).getName());
//			System.out.println(ingredientList2);
		}
		return ingredientList2;
	} 
	
	

//	public Map<String, Object> ingredientAll2(String name) {
//
//		Map<String, Object> ingredientList2 = fridgeDao.ingredientAll2();
//		return ingredientList2;
//	}

	
}
