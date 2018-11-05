package com.pt.msarchive.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: HealthRecord
 * @Description: health_record表，客户的健康信息记录
 * @author 谯雕
 * @date 2018年11月5日
 *
 */
@Entity
@Table(name="health_record")
public class HealthRecord {

	@Id
	@Column(name="id",columnDefinition="bigint(20)",updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="customerId",columnDefinition="varchar(32)",updatable=false)
	private String customerId;
	
	@Column(name="record_date",columnDefinition="date",updatable=false,insertable=false)
	private Date recordDate;
	
	@Column(name="record_time",columnDefinition="time",updatable=false,insertable=false)
	private Date record_time;
	
	@Column(name="data",columnDefinition="text",updatable=false)
	private String data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public Date getRecord_time() {
		return record_time;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}