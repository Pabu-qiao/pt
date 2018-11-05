package com.pt.msarchive.model.item;

/**
 * @ClassName: RecordItem
 * @Description: 记录表中的记录item
 * @author 谯雕
 * @date 2018年11月5日
 *
 */
public class RecordItem {
	
	private String key;
	private String value;
	/**
	 * @Fields exist:表示这个item是该增加还是该移除，true：增加，false：移除，默认增加
	 */
	private Boolean exist=true;
	
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
	public Boolean getExist() {
		return exist;
	}
	public void setExist(Boolean exist) {
		this.exist = exist;
	}
}
