package com.kong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kong.entity.CookEntity;

public interface CookRepository extends JpaRepository<CookEntity, String>{
	
}