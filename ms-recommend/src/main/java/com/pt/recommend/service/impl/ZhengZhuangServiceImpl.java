package com.pt.recommend.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.recommend.dao.ZhengZhuangDao;
import com.pt.recommend.entity.FuWu;
import com.pt.recommend.entity.ZhengZhuang;
import com.pt.recommend.model.Plan;
import com.pt.recommend.service.IZhengZhuangService;

@Service
public class ZhengZhuangServiceImpl implements IZhengZhuangService{

	@Autowired
	private ZhengZhuangDao dao;
	
	@Override
	@Transactional
	public List<Plan> getPlanByZhengZhuang(List<String> zhengzhuangs) {
		// TODO Auto-generated method stub
		List<ZhengZhuang> findBySymptomIn = dao.findByZhengZhuangIn(zhengzhuangs);
		
		List<Plan> result=new ArrayList<Plan>();
		Set<FuWu> machines=new HashSet<FuWu>();
		if (findBySymptomIn.size()>0) {
			abc(result, findBySymptomIn, machines, 0);
			//筛选方案
			return select(result);
		}
		return null;
	}
	
	private void abc(List<Plan> result,List<ZhengZhuang> total,Set<FuWu> machines,Integer index){
		ZhengZhuang symptom = total.get(index);
		Set<FuWu> temp = symptom.getFuWu();
		for (FuWu machine : temp) {
			Plan plan=new Plan();
			Set<FuWu> set = new HashSet<FuWu>();
			set.addAll(machines);
			set.remove(machine);
			set.add(machine);
			if (index + 1 == total.size()) {
				plan.setFuWuXiang(set);
				for (FuWu fuWu : set) {
					plan.setReDu((plan.getReDu()==null?0:plan.getReDu())+(fuWu.getReDu()==null?0:fuWu.getReDu()));
					plan.setJiaGe((plan.getJiaGe()==null?new BigDecimal(0):plan.getJiaGe()).add(fuWu.getJiaGe()==null?new BigDecimal(0):fuWu.getJiaGe()));
					plan.setShiChang((plan.getShiChang()==null?0:plan.getShiChang())+(fuWu.getShiChang()==null?0:fuWu.getShiChang()));
				}
				result.add(plan);
			} else {
				abc(result,total,set, index+1);
			}
		}
	}
	
	private List<Plan> select(List<Plan> plans){
		List<Plan> result=new ArrayList<Plan>();
		if (plans!=null&&plans.size()>0) {
			Plan hotPlan=new Plan();
			hotPlan.setShuoMing("本方案为当季热门方案");
			Plan timePlan=new Plan();
			timePlan.setShuoMing("本方案可以为客户节约更多的时间");
			Plan pricePlan=new Plan();
			pricePlan.setShuoMing("本方案经济实惠");
			for (Plan plan : plans) {
				if (hotPlan.getReDu()==null||plan.getReDu()>hotPlan.getReDu()) {
					hotPlan.setFuWuXiang(plan.getFuWuXiang());
					hotPlan.setReDu(plan.getReDu());;
					hotPlan.setJiaGe(plan.getJiaGe());
					hotPlan.setShiChang(plan.getShiChang());
					hotPlan.setFangAnMing("火热爆款");
				}
				if (plans.size()>1) {
					if (timePlan.getShiChang()==null||plan.getShiChang()<timePlan.getShiChang()) {
						timePlan.setFuWuXiang(plan.getFuWuXiang());
						timePlan.setReDu(plan.getReDu());;
						timePlan.setJiaGe(plan.getJiaGe());
						timePlan.setShiChang(plan.getShiChang());
						timePlan.setFangAnMing("节省时间");
					}
				}
				if(plans.size()>2){
					if (pricePlan.getJiaGe()==null||plan.getJiaGe().compareTo(pricePlan.getJiaGe())<0) {
						pricePlan.setFuWuXiang(plan.getFuWuXiang());
						pricePlan.setReDu(plan.getReDu());;
						pricePlan.setJiaGe(plan.getJiaGe());
						pricePlan.setShiChang(plan.getShiChang());
						pricePlan.setFangAnMing("经济实惠");
					}
				}
			}
			
			result.add(hotPlan);
			if (plans.size()>1) {
				result.add(timePlan);
			}
			if(plans.size()>2){
				result.add(pricePlan);
			}
			return result;
		}
		return null;
	}

	@Override
	@Transactional
	public Map<String, List<ZhengZhuang>> getAllZhengZhuang() {
		// TODO Auto-generated method stub
		List<ZhengZhuang> all = dao.findAll();
		Map<String, List<ZhengZhuang>> map=new HashMap<String, List<ZhengZhuang>>();
		for (ZhengZhuang zhengZhuang : all) {
			zhengZhuang.setFuWu(null);
			if (map.get(zhengZhuang.getFenLei())==null) {
				map.put(zhengZhuang.getFenLei(), new ArrayList<ZhengZhuang>());
			}
			map.get(zhengZhuang.getFenLei()).add(zhengZhuang);
		}
		return map;
	}
}
