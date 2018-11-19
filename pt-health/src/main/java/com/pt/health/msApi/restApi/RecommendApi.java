package com.pt.health.msApi.restApi;

public class RecommendApi {
	private final static String BASE="/msrecommend";
	
	public final static String ZHENGZHUANGS=BASE+"/zhengZhuangs";
	public final static String RECOMMENDS=BASE+"/recommends?params={zhengZhuangs}";
	public final static String PLANS=BASE+"/plans?id={ids}";
	public final static String ZHUSUS=BASE+"/zhuSus";
}
