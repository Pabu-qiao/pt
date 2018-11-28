package com.pt.recommend.model;

import java.util.List;

import com.pt.recommend.util.PtEnum;

public class PtResult<T> {

	private String status;
	private String msg;
	private List<T> data;
	
	private PtResult(){}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(PtEnum ptEnum) {
		this.status = ptEnum.getCode();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(PtEnum ptEnum) {
		this.msg = ptEnum.getDesc();
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public static<T> PtResult<T> build(PtEnum ptEnum){
		if (ptEnum==PtEnum.CODE_02) {
			return ok(null);
		}
		PtResult<T> ptResult = new PtResult<>();
		ptResult.setStatus(ptEnum);
		ptResult.setMsg(ptEnum);
		ptResult.setData(null);
		return ptResult;
	}
	
	public static<T> PtResult<T> ok(List<T> data) {
		PtResult<T> ptResult = new PtResult<>();
		if (data!=null) {
			ptResult.setStatus(PtEnum.CODE_01);
			ptResult.setMsg(PtEnum.CODE_01);
			ptResult.setData(data);
		}else {
			ptResult.setStatus(PtEnum.CODE_02);
			ptResult.setMsg(PtEnum.CODE_02);
			ptResult.setData(null);
		}
		return ptResult;
	}
}
