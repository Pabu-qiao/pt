package com.pt.recommend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt.recommend.entity.FuWu;

@Repository
public interface FuWuDao extends JpaRepository<FuWu, Integer>{
	
	
}
