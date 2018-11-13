package com.pt.recommend.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fang_an")
public class FangAn implements Cloneable {

	@Id
	@Column(name="id",columnDefinition="int(11)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name",columnDefinition="varchar(32)")
	private String name;
	
	@Column(name="jia_ge",columnDefinition="decimal(10)")
	private BigDecimal jiaGe;
	
	@Column(name="shi_chang",columnDefinition="int(11)")
	private Integer shiChang;
	
	@Column(name="re_du",columnDefinition="int(11)")
	private Integer reDu;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getJiaGe() {
		return jiaGe;
	}
	public void setJiaGe(BigDecimal jiaGe) {
		this.jiaGe = jiaGe;
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
	
	public FangAn clone() {
		FangAn clone=null;
		try {
			clone=(FangAn) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}
}
