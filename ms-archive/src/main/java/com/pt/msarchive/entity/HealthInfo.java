package com.pt.msarchive.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: HealthInfo
 * @Description: HealthInfo表，客户的健康信息
 * @author 谯雕
 * @date 2018年11月5日
 *
 */
@Entity
@Table(name="health_info")
public class HealthInfo implements Cloneable{

	
	@Id
	@Column(name="customerId",columnDefinition="varchar(32)",updatable=false)
	private String customerId;
	
	@Column(name="create_date",columnDefinition="datetime",updatable=false,insertable=false)
	private Date create_date;
	
	@Column(name="update_date",columnDefinition="datetime",updatable=false,insertable=false)
	private Date update_date;
	
	@Column(name="info",columnDefinition="text")
	private String info;
	
	@Column(name="version",columnDefinition="int(11)",updatable=false,insertable=false)
	private Integer version;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getVersion() {
		return version;
	}
	
	public HealthInfo clone() {
		HealthInfo clone=null;
		try {
			clone = (HealthInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clone.create_date=(Date) this.create_date.clone();
		clone.update_date=(Date) this.update_date.clone();
		return clone;
	}
}
