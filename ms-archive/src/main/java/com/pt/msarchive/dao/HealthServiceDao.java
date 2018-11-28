package com.pt.msarchive.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt.msarchive.entity.HealthService;

/**
 * @ClassName: HealthServiceDao
 * @Description: HealthService表的dao
 * @author 谯雕
 * @date 2018年10月24日
 *
 */
@Repository
public interface HealthServiceDao extends JpaRepository<HealthService, Integer>{
	
	/**
	 * @Title: findByCustomerIdAndServiceDateGreaterThanEqualAndServiceDateLessThanEqual
	 * @Description: 根据id和起止时间，查询用户在指定时间段内的服务记录
	 * @param customerId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	List<HealthService> findByCustomerIdAndServiceDateGreaterThanEqualAndServiceDateLessThanEqual(String customerId,LocalDate beginDate,LocalDate endDate);
}
