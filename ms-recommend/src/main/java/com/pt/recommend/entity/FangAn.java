package com.pt.recommend.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@Column(name="fan_wei",columnDefinition="text")
	private String fanWei;
	
	@JoinTable(name = "fangAn_fuWu", 
			joinColumns = {@JoinColumn(name = "fangAn_id", referencedColumnName = "id") }, 
			inverseJoinColumns = {@JoinColumn(name = "fuWu_id", referencedColumnName = "id") })
	@ManyToMany
	private Set<FuWu> fuWu = new HashSet<FuWu>();
	
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
	public String getFanWei() {
		return fanWei;
	}
	public void setFanWei(String fanWei) {
		this.fanWei = fanWei;
	}
	public Set<FuWu> getFuWu() {
		return fuWu;
	}
	public void setFuWu(Set<FuWu> fuWu) {
		this.fuWu = fuWu;
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
