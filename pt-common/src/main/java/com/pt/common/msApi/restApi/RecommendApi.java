package com.pt.common.msApi.restApi;

public class RecommendApi {
	private final static String BASE="/msrecommend";
	
	public final static String ZHENGZHUANGS=BASE+"/zhengZhuangs";
	public final static String RECOMMENDS=BASE+"/recommends?params={zhengZhuangs}";
}