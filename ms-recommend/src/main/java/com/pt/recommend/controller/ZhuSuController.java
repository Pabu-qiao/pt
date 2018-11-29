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
import com.pt.recommend.service.FangAnService;
import com.pt.recommend.service.ZhuSuService;
import com.ptutil.ResponseUtil;
import com.ptutil.enums.PtEnum;
import com.ptutil.message.MessageModel;
import com.ptutil.message.MessageProducer;
import com.ptutil.message.MessageTag;
import com.ptutil.message.MessageTopic;
import com.ptutil.ptbase.PtResult;

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
		
		PtResult<ZhuSu> pt = zhuSuService.getPlanByZhuSuId(ids);
		if (pt.getStatus()!=PtEnum.CODE_01.getCode()&&pt.getStatus()!=PtEnum.CODE_02.getCode()) {
			return ResponseUtil.toJson(pt);
		}
		List<ZhuSu> list=pt.getData();
		
		Set<FangAn> fangAns=new HashSet<FangAn>();
		for (ZhuSu zhuSu : list) {
			fangAns.add(zhuSu.getFangAn());
		}
		List<Set<FangAn>> data=new ArrayList<Set<FangAn>>();
		data.add(fangAns);
		return ResponseUtil.toJson(PtResult.ok(data));
	}
	
	@GetMapping("/plans2")
	public ResponseEntity<String> getPlanByZhuSu(@RequestParam String zhuSus){
		zhuSus=zhuSus.replace("[", "").replace("]", "").replace("\"", "");
		String[] split = zhuSus.split(",");
		List<String> names = Arrays.asList(split);
		
		PtResult<ZhuSu> pt = zhuSuService.getPlanByZhuSus(names);
		if (pt.getStatus()!=PtEnum.CODE_01.getCode()&&pt.getStatus()!=PtEnum.CODE_02.getCode()) {
			return ResponseUtil.toJson(pt);
		}
		List<ZhuSu> list=pt.getData();
		
		Set<FangAn> fangAns=new HashSet<FangAn>();
		for (ZhuSu zhuSu : list) {
			fangAns.add(zhuSu.getFangAn());
		}
		
		List<Set<FangAn>> data=new ArrayList<Set<FangAn>>();
		data.add(fangAns);
		return ResponseUtil.toJson(PtResult.ok(data));
	}
	
	@GetMapping("/zhuSus")
	public ResponseEntity<String> getAllZhuSu(){
		PtResult<ZhuSu> pt = zhuSuService.getAllZhuSu();
		if (pt.getStatus()!=PtEnum.CODE_01.getCode()&&pt.getStatus()!=PtEnum.CODE_02.getCode()) {
			return ResponseUtil.toJson(pt);
		}
		List<ZhuSu> list=pt.getData();
		
		for (ZhuSu zhuSu : list) {
			zhuSu.setFangAn(null);
		}
		return ResponseUtil.toJson(PtResult.ok(list));
	}
	
	@PostMapping("/zhuSus")
	public ResponseEntity<String> saveZhuSu(@RequestBody JSONObject jsonObject){
		String id = jsonObject.getString("id");
		String name = jsonObject.getString("name");
		String fangAnId = jsonObject.getString("fangAnId");
		
		PtResult<FangAn> pt = fangAnService.getById(new Integer(fangAnId));
		if (pt.getStatus()!=PtEnum.CODE_01.getCode()&&pt.getStatus()!=PtEnum.CODE_02.getCode()) {
			return ResponseUtil.toJson(pt);
		}
		FangAn fangAn = pt.getData().get(0);
		ZhuSu zhuSu=new ZhuSu();
		zhuSu.setId(new Integer(id));
		zhuSu.setName(name);
		
		MessageModel model=new MessageModel();
		model.setTopic(MessageTopic.putaiArchive);
		model.setTag(MessageTag.ZHUSU_CREATE);
		model.setId(zhuSu.getId()+"");
		
		JSONObject info=new JSONObject();
		info.put("zhuSu", JSON.toJSONString(zhuSu));
		info.put("fangAn", JSON.toJSONString(fangAn));
		model.setInfo(info);
		
		producer.sendMessage(model);
		
		return ResponseUtil.toJson(PtResult.ok(null));
	}
}
