package com.pt.msarchive.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;
import com.pt.msarchive.enums.QUESTION_ORIGIN;
import com.pt.msarchive.model.item.HealthQuestionItem;

/**
 * @ClassName: HealthQuestion
 * @Description: 所有问题的表
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
@Entity
@Table(name="health_question")
public class HealthQuestion implements Cloneable{

	@Id
	@Column(name="id",columnDefinition="bigint(20)",updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="single",columnDefinition="bit(1)")
	private Boolean single;
	
	@Column(name="code",columnDefinition="varchar(32)")
	private String code;
	
	@Column(name="category",columnDefinition="varchar(32)")
	private String desc;
	
	@Column(name="origin",columnDefinition="enum('CUSTOMER','SYSTEM')")
	@Enumerated(EnumType.STRING)
	private QUESTION_ORIGIN origin;
	
	@Column(name="items",columnDefinition="text")
	private String items;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getSingle() {
		return single;
	}
	public void setSingle(Boolean single) {
		this.single = single;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public QUESTION_ORIGIN getOrigin() {
		return origin;
	}
	public void setOrigin(QUESTION_ORIGIN origin) {
		this.origin = origin;
	}
	public String getItems() {
		return items;
	}
	public void setItems(List<HealthQuestionItem> items) {
		this.items = JSON.toJSONString(items);
	}
	
	public HealthQuestion clone() {
		HealthQuestion clone=null;
		try {
			clone=(HealthQuestion) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}
}