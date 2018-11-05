package com.pt.msarchive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt.msarchive.entity.HealthInfo;

/**
 * @ClassName: QuestionDao
 * @Description: HealthInfo表的dao
 * @author 谯雕
 * @date 2018年10月23日
 *
 */
@Repository
public interface HealthInfoDao extends JpaRepository<HealthInfo, String> {
	
}
