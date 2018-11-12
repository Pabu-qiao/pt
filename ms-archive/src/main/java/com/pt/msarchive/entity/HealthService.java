package com.pt.msarchive.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: HealthService
 * @Description: health_service表，客户的服务记录
 * @author 谯雕
 * @date 2018年11月5日
 *
 */
@Entity
@Table(name="health_service")
public class HealthService implements Cloneable{

	@Id
	@Column(name="id",columnDefinition="bigint(20)",updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="customerId",columnDefinition="varchar(11)",updatable=false)
	private String customerId;
	
	@Column(name="service_date",columnDefinition="datetime",updatable=false,insertable=false)
	private Date serviceDate;
	
	@Column(name="service",columnDefinition="text",updatable=false)
	private String service;

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

	public Date getServiceDate() {
		return serviceDate;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Override
	protected HealthService clone(){
		HealthService clone=null;
		try {
			clone=(HealthService) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clone.serviceDate=(Date) this.serviceDate.clone();
		return clone;
	}
	
	
}