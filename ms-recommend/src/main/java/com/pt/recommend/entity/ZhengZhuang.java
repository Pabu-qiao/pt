package com.pt.recommend.entity;

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
@Table(name = "zhengZhuang")
public class ZhengZhuang implements Cloneable {

	@Id
	@Column(name = "id", columnDefinition = "int(11)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "zhengZhuang", columnDefinition = "varchar(32)")
	private String zhengZhuang;

	@Column(name = "fenLei", columnDefinition = "varchar(32)")
	private String fenLei;

	@JoinTable(name = "zhengZhuang_fuWu", joinColumns = {
			@JoinColumn(name = "zhengZhuang_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "fuWu_id", referencedColumnName = "id") })
	@ManyToMany
	private Set<FuWu> fuWu = new HashSet<FuWu>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFenLei() {
		return fenLei;
	}

	public void setFenLei(String fenLei) {
		this.fenLei = fenLei;
	}

	public String getZhengZhuang() {
		return zhengZhuang;
	}

	public void setZhengZhuang(String zhengZhuang) {
		this.zhengZhuang = zhengZhuang;
	}

	public Set<FuWu> getFuWu() {
		return fuWu;
	}

	public void setFuWu(Set<FuWu> fuWu) {
		this.fuWu = fuWu;
	}

	public ZhengZhuang clone() {
		ZhengZhuang clone=null;
		try {
			clone = (ZhengZhuang) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (FuWu temp : clone.fuWu) {
			temp = temp.clone();
		}
		return clone;
	}

}
