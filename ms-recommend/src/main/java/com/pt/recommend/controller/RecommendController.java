package com.pt.recommend.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt.common.util.ResponseUtil;
import com.pt.recommend.entity.FuWu;
import com.pt.recommend.entity.ZhengZhuang;
import com.pt.recommend.model.Plan;
import com.pt.recommend.service.IZhengZhuangService;

@RestController
public class RecommendController {

	@Autowired
	private IZhengZhuangService iZhengZhuangService;
	
	
	@GetMapping("/recommends")
	public ResponseEntity<String> getRecommend(@RequestParam String params) {
		params=params.replace("[", "").replace("]", "").replace("\"", "");
		String[] split = params.split(",");
		List<String> zhengzhuangs = Arrays.asList(split);
		
		List<ZhengZhuang> all = iZhengZhuangService.getPlanByZhengZhuang(zhengzhuangs);
		List<Plan> result = new ArrayList<Plan>();
		Set<FuWu> machines = new HashSet<FuWu>();
		if (all.size() > 0) {
			abc(result, all, machines, 0);
		}
		//筛选方案
		List<Plan> temp = select(result);
		return ResponseUtil.toJson(temp);
	}
	
	@GetMapping("/zhengZhuangs")
	public ResponseEntity<String> getAllZhengZhuang(){
		List<ZhengZhuang> all = iZhengZhuangService.getAllZhengZhuang();
		Map<String, List<ZhengZhuang>> map = new HashMap<String, List<ZhengZhuang>>();
		for (ZhengZhuang zhengZhuang : all) {
			ZhengZhuang clone = zhengZhuang.clone();
			clone.setFuWu(null);
			if (map.get(clone.getFenLei()) == null) {
				map.put(clone.getFenLei(), new ArrayList<ZhengZhuang>());
			}
			map.get(clone.getFenLei()).add(clone);
		}
		return ResponseUtil.toJson(map);
	}
	
	
	private void abc(List<Plan> result, List<ZhengZhuang> total, Set<FuWu> machines, Integer index) {
		ZhengZhuang symptom = total.get(index);
		Set<FuWu> temp = symptom.getFuWu();
		for (FuWu machine : temp) {
			Plan plan = new Plan();
			Set<FuWu> set = new HashSet<FuWu>();
			set.addAll(machines);
			set.remove(machine);
			set.add(machine);
			if (index + 1 == total.size()) {
				plan.setFuWuXiang(set);
				for (FuWu fuWu : set) {
					plan.setReDu((plan.getReDu() == null ? 0 : plan.getReDu())
							+ (fuWu.getReDu() == null ? 0 : fuWu.getReDu()));
					plan.setJiaGe((plan.getJiaGe() == null ? new BigDecimal(0) : plan.getJiaGe())
							.add(fuWu.getJiaGe() == null ? new BigDecimal(0) : fuWu.getJiaGe()));
					plan.setShiChang((plan.getShiChang() == null ? 0 : plan.getShiChang())
							+ (fuWu.getShiChang() == null ? 0 : fuWu.getShiChang()));
				}
				result.add(plan);
			} else {
				abc(result, total, set, index + 1);
			}
		}
	}

	private List<Plan> select(List<Plan> plans) {
		List<Plan> result = new ArrayList<Plan>();
		if (plans != null && plans.size() > 0) {
			Plan hotPlan = new Plan();
			hotPlan.setShuoMing("本方案为当季热门方案");
			Plan timePlan = new Plan();
			timePlan.setShuoMing("本方案可以为客户节约更多的时间");
			Plan pricePlan = new Plan();
			pricePlan.setShuoMing("本方案经济实惠");
			for (Plan plan : plans) {
				if (hotPlan.getReDu() == null || plan.getReDu() > hotPlan.getReDu()) {
					hotPlan.setFuWuXiang(plan.getFuWuXiang());
					hotPlan.setReDu(plan.getReDu());
					;
					hotPlan.setJiaGe(plan.getJiaGe());
					hotPlan.setShiChang(plan.getShiChang());
					hotPlan.setFangAnMing("火热爆款");
				}
				if (plans.size() > 1) {
					if (timePlan.getShiChang() == null || plan.getShiChang() < timePlan.getShiChang()) {
						timePlan.setFuWuXiang(plan.getFuWuXiang());
						timePlan.setReDu(plan.getReDu());
						;
						timePlan.setJiaGe(plan.getJiaGe());
						timePlan.setShiChang(plan.getShiChang());
						timePlan.setFangAnMing("节省时间");
					}
				}
				if (plans.size() > 2) {
					if (pricePlan.getJiaGe() == null || plan.getJiaGe().compareTo(pricePlan.getJiaGe()) < 0) {
						pricePlan.setFuWuXiang(plan.getFuWuXiang());
						pricePlan.setReDu(plan.getReDu());
						;
						pricePlan.setJiaGe(plan.getJiaGe());
						pricePlan.setShiChang(plan.getShiChang());
						pricePlan.setFangAnMing("经济实惠");
					}
				}
			}

			result.add(hotPlan);
			if (plans.size() > 1) {
				result.add(timePlan);
			}
			if (plans.size() > 2) {
				result.add(pricePlan);
			}
			return result;
		}
		return null;
	}
}
