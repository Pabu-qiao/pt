package com.pt.recommend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pt.recommend.entity.FangAn;
import com.pt.recommend.entity.ZhuSu;
import com.pt.recommend.message.MessageModel;
import com.pt.recommend.message.MessageProducer;
import com.pt.recommend.message.MessageTag;
import com.pt.recommend.message.MessageTopic;
import com.pt.recommend.service.FangAnService;
import com.pt.recommend.service.ZhuSuService;
import com.pt.recommend.util.ResponseUtil;

@RestController
public class ZhuSuController {

	@Autowired
	private ZhuSuService zhuSuService;
	@Autowired
	private FangAnService fangAnService;
	
	private MessageProducer producer=MessageProducer.getInstance();
	
	@GetMapping("/plans")
	public ResponseEntity<String> getPlanByZhuSus(@RequestParam String id){
		id=id.replace("[", "").replace("]", "").replace("\"", "");
		String[] split = id.split(",");
		List<Integer> ids=new ArrayList<Integer>();
		for (String str : split) {
			ids.add(new Integer(str));
		}
		
		List<ZhuSu> list = zhuSuService.getPlanByZhuSuId(ids);
		Set<FangAn> fangAns=new HashSet<FangAn>();
		for (ZhuSu zhuSu : list) {
			fangAns.add(zhuSu.getFangAn());
		}
		
		return ResponseUtil.toJson(fangAns);
	}
	
	@GetMapping("/plans2")
	public ResponseEntity<String> getPlanByZhuSu(@RequestParam String zhuSus){
		zhuSus=zhuSus.replace("[", "").replace("]", "").replace("\"", "");
		String[] split = zhuSus.split(",");
		List<String> names = Arrays.asList(split);
		
		List<ZhuSu> list = zhuSuService.getPlanByZhuSus(names);
		Set<FangAn> fangAns=new HashSet<FangAn>();
		for (ZhuSu zhuSu : list) {
			fangAns.add(zhuSu.getFangAn());
		}
		
		return ResponseUtil.toJson(fangAns);
	}
	
	@GetMapping("/zhuSus")
	public ResponseEntity<String> getAllZhuSu(){
		List<ZhuSu> list = zhuSuService.getAllZhuSu();
		for (ZhuSu zhuSu : list) {
			zhuSu.setFangAn(null);
		}
		return ResponseUtil.toJson(list);
	}
	
	@PostMapping("/zhuSus")
	public ResponseEntity<String> saveZhuSu(@RequestBody JSONObject jsonObject){
		String id = jsonObject.getString("id");
		String name = jsonObject.getString("name");
		String fangAnId = jsonObject.getString("fangAnId");
		
		FangAn fangAn = fangAnService.getById(new Integer(fangAnId));
		ZhuSu zhuSu=new ZhuSu();
		zhuSu.setId(new Integer(id));
		zhuSu.setName(name);
		
		MessageModel model=new MessageModel();
		model.setTopic(MessageTopic.putaiArchive);
		model.setTag(MessageTag.zhuSu_create);
		model.setId(zhuSu.getId()+"");
		
		JSONObject info=new JSONObject();
		info.put("zhuSu", JSON.toJSONString(zhuSu));
		info.put("fangAn", JSON.toJSONString(fangAn));
		model.setInfo(info);
		
		producer.sendMessage(model);
		
		return ResponseUtil.toJson("新增完成");
	}
}
