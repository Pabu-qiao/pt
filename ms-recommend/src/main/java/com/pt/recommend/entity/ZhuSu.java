package com.pt.recommend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="zhu_su")
public class ZhuSu implements Cloneable{

	@Id
	@Column(name="id",columnDefinition="int(11)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name",columnDefinition="varchar(32)")
	private String name;
	
	@OneToOne
	@JoinColumn(name="fang_an_id")
	private FangAn fangAn;
	
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
	public FangAn getFangAn() {
		return fangAn;
	}
	public void setFangAn(FangAn fangAn) {
		this.fangAn = fangAn;
	}
	
	public ZhuSu clone() {
		ZhuSu clone=null;
		try {
			clone=(ZhuSu) super.clone();
			clone.fangAn=fangAn.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}
	
}
