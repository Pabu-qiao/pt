package com.pt.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.pt.common.BaseTest;

public class ResponseUtilTest extends BaseTest{

	@Test
	public void testToJson() {
		String temp="[{\"code\":\"01\",\"desc\":\"正常\"},{\"code\":\"02\",\"desc\":\"不正常\"},{\"code\":\"03\",\"desc\":\"未知\"}]";
		ResponseEntity<String> json = ResponseUtil.toJson(temp);
		Assert.assertEquals("转换String异常", "[{\"code\":\"01\",\"desc\":\"正常\"},{\"code\":\"02\",\"desc\":\"不正常\"},{\"code\":\"03\",\"desc\":\"未知\"}]", json.getBody());
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
		ResponseEntity<String> listJson = ResponseUtil.toJson(list);
		Assert.assertEquals("转换List异常", "[\"1\",\"2\"]",listJson.getBody());
		Map<String, String> map=new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		ResponseEntity<String> mapJson = ResponseUtil.toJson(map);
		Assert.assertEquals("转换map异常", "{\"1\":\"1\",\"2\":\"2\"}",mapJson.getBody());
		Set<String> set=new HashSet<>();
		set.add("1");
		set.add("2");
		ResponseEntity<String> setJson = ResponseUtil.toJson(set);
		Assert.assertEquals("转换set异常", "[\"1\",\"2\"]",setJson.getBody());
	}

}
