package com.pt.msarchive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt.msarchive.entity.HealthQuestion;

/**
 * @ClassName: HealthQuestionDao
 * @Description: HealthQuestion表的dao
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
@Repository
public interface HealthQuestionDao extends JpaRepository<HealthQuestion, Integer>{

}
