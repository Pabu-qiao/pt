package com.pt.recommend.model;

import java.math.BigDecimal;
import java.util.Set;

import com.pt.recommend.entity.FuWu;

public class Plan {
	private String fangAnMing;
	private Set<FuWu> fuWuXiang;
	private String shuoMing;
	private Integer shiChang;
	private	Integer reDu;
	private BigDecimal jiaGe;
	
	public String getFangAnMing() {
		return fangAnMing;
	}
	public void setFangAnMing(String fangAnMing) {
		this.fangAnMing = fangAnMing;
	}
	public Set<FuWu> getFuWuXiang() {
		return fuWuXiang;
	}
	public void setFuWuXiang(Set<FuWu> fuWuXiang) {
		this.fuWuXiang = fuWuXiang;
	}
	public String getShuoMing() {
		return shuoMing;
	}
	public void setShuoMing(String shuoMing) {
		this.shuoMing = shuoMing;
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
	
}
