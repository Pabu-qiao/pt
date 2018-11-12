package com.pt.recommend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt.recommend.entity.ZhuSu;

@Repository
public interface ZhuSuDao extends JpaRepository<ZhuSu, Integer>{
	List<ZhuSu> findByIdIn(List<Integer> ids);
	
}
