package com.pt.msarchive.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt.msarchive.entity.HealthRecord;

/**
 * @ClassName: HealthRecordDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 谯雕
 * @date 2018年11月5日
 *
 */
@Repository
public interface HealthRecordDao extends JpaRepository<HealthRecord, Integer>{

	/**
	 * @Title: findByCustomerIdAndRecordDateGreaterThanEqualAndRecordDateLessThanEqual
	 * @Description: 根据id和起止时间，查询用户在指定时间段内的健康记录
	 * @param customerId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	List<HealthRecord> findByCustomerIdAndRecordDateGreaterThanEqualAndRecordDateLessThanEqual(String customerId,Date beginDate,Date endDate);
}
