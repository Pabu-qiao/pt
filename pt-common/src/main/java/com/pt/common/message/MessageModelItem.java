package com.pt.common.message;

public class MessageModelItem {
	private String key;
	private String value;
	private Boolean rm=false;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Boolean getRm() {
		return rm;
	}
	public void setRm(Boolean rm) {
		this.rm = rm;
	}
}
