package com.pt.common.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

public class RestUtil {

	private static final Logger log = LoggerFactory.getLogger(RestUtil.class);
	
	public static String getResult(String url, Object...params) {
		return doGet("http://"+url, params);
	}
	
	public static String getHttpsResult(String url, Object...params) {
		return doGet("https://"+url, params);
	}
	
	public static String getResult(String url, Map<String, String> map) {
		return doGet("http://"+url, map);
	}
	
	public static String getHttpsResult(String url, Map<String, String> map) {
		return doGet("https://"+url, map);
	}
	
	/**
	 * @Title: doGet
	 * @Description: 通过URL和params调用微服务并返回
	 * @param url
	 * @param params
	 * @return
	 */
	private static String doGet(String url,Object...params) {
		log.info("传入对象数组");
		RestTemplate restTemplate=new RestTemplate();
		
		try {
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
//			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class,
//					params);
//			return result.getBody();
			
			//上面注释的是通用方法，下面这个是具体方法
			return restTemplate.getForObject(url,String.class,params);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("url或者参数错误");
			e.printStackTrace();
		}
		return "";
	}
	
	private static String doGet(String url,Map<String, String> map) {
		log.info("传入map");
		RestTemplate restTemplate=new RestTemplate();
		try {

			if (map!=null) {
				return restTemplate.getForObject(url,String.class,map);
			}
			return restTemplate.getForObject(url, String.class);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("url或者参数错误");
			e.printStackTrace();
		}
		return "";
	}
	
	
	
	
	
	
	
	
	public static String sendAsyncPost(String url, Map<String, String> map,JSONObject jsonData) {
		url="http://"+url;
		RestTemplate restTemplate=new RestTemplate();
		if (map!=null) {
			return restTemplate.postForObject(url, jsonData, String.class, map);
		}
		return restTemplate.postForObject(url, jsonData, String.class);
	}
	
	public static void sendAsyncPut(String url, Map<String, String> map,JSONObject jsonData) {
		url="http://"+url;
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.put(url, jsonData, map);
	}
	
	public static void sendAsyncDelete(String url, Map<String, String> map) {
		url="http://"+url;
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.delete(url, map);
	}
}
