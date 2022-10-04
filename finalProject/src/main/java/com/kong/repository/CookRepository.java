package com.kong.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kong.entity.CookEntity;

public interface CookRepository extends JpaRepository<CookEntity, String>,JpaSpecificationExecutor<CookEntity>{
	
//	Optional<CookEntity> findByCook_id(String cook_id);
//	List<CookEntity> findByName(String name);
//	List<CookEntity> findByName(String name, Sort sort);
	List<CookEntity> findByEmailOrUserId(String id,String name);
}                                                                                                                                                                                                                                                                                                                                                                                      