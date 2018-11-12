package com.pt.common.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @ClassName: ResponseUtil
 * @Description: controller返回工具类，将返回结果格式设置为json格式
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
public class ResponseUtil {

	public static ResponseEntity<String> toJson(Object temp){
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		//如果传入对象已经是json字符串格式，就不再使用JSON格式转换，否则会多 /
		if (temp instanceof String) {
			return new ResponseEntity<String>(temp.toString(),header,HttpStatus.OK);
		}
		return new ResponseEntity<String>(JSON.toJSONString(temp,SerializerFeature.DisableCircularReferenceDetect),header,HttpStatus.OK);
	}
}
