package com.pt.recommend.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fuWu")
public class FuWu {

	@Id
	@Column(name="id",columnDefinition="int(11)")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="yingWenMing",columnDefinition="varchar(32)")
	private String yingWenMing;
	
	@Column(name="zhongWenMing",columnDefinition="varchar(32)")
	private String zhongWenMing;
	
	@Column(name="shiChang",columnDefinition="int(11)")
	private Integer shiChang;
	
	@Column(name="reDu",columnDefinition="int(11)")
	private Integer reDu;
	
	@Column(name="jiaGe",columnDefinition="decimal(12)")
	private BigDecimal jiaGe;
	
	
	/*@ManyToMany(mappedBy="machines")
	private Set<Symptom> symptoms=new HashSet<Symptom>();*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYingWenMing() {
		return yingWenMing;
	}

	public void setYingWenMing(String yingWenMing) {
		this.yingWenMing = yingWenMing;
	}

	public String getZhongWenMing() {
		return zhongWenMing;
	}

	public void setZhongWenMing(String zhongWenMing) {
		this.zhongWenMing = zhongWenMing;
	}

	public Integer getShiChang() {
		return shiChang;
	}

	public void setShiChang(Integer shiChang) {
		this.shiChang = shiChang;
	}

	public Integer getReDu() {
		return reDu;
	}

	public void setReDu(Integer reDu) {
		this.reDu = reDu;
	}

	public BigDecimal getJiaGe() {
		return jiaGe;
	}

	public void setJiaGe(BigDecimal jiaGe) {
		this.jiaGe = jiaGe;
	}
	

	/*public Set<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Set<Symptom> symptoms) {
		this.symptoms = symptoms;
	}*/
	
}
