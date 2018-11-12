package com.pt.recommend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt.recommend.entity.FangAn;

@Repository
public interface FangAnDao extends JpaRepository<FangAn, Integer>{
	
	
}
