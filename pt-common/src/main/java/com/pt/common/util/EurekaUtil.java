package com.pt.common.util;

import java.util.List;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

/**
 * @ClassName: EurekaUtil
 * @Description: 构建一个单例模式的工具类，用来获取微服务的地址
 * @author 谯雕
 * @date 2018年10月16日
 *
 */
public class EurekaUtil {
	
	private static final EurekaUtil EUREKAUTIL=new EurekaUtil();
	
	private EurekaClient eurekaClient;
	
	private EurekaUtil() {
		
	}
	
	public static EurekaUtil getInstance() {
		return EUREKAUTIL;
	}
	
	/**
	 * @Title: init
	 * @Description: SpringBoot启动时调用此方法，初始化eurekaClient
	 * @param eurekaClient
	 */
	public void init (EurekaClient eurekaClient) {
		this.eurekaClient=eurekaClient;
	}
	
	/**
	 * @Title: getServiceUrl
	 * @Description: 根据传入的微服务项目名和api，返回微服务地址
	 * @param vipAddress	项目名称
	 * @param restapi		api
	 * @return
	 */
	public String getServiceUrl(String vipAddress, String restapi) {
		String url="";
		
		List<InstanceInfo> list = eurekaClient.getInstancesByVipAddress(vipAddress, false);
		if (list!=null&&list.size()>0) {
			InstanceInfo serviceInfo = list.get(0);
			url=serviceInfo.getIPAddr()+":"+serviceInfo.getPort()+restapi;
		}
		return url;
	}

}
