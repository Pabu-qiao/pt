package com.pt.recommend.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: CombinationUtil
 * @Description: 组合util
 * @author 谯雕
 * @date 2018年11月21日
 *
 */
public class CombinationUtil {
	/**
	 * @Title: combination
	 * @Description: 组合，1,2,3;a,b,c; 重新组合为1a,1b,1c,2a,2b,2c,3a,3b,3c;
	 * @param list	初始list
	 * @param preSet	
	 * @param index
	 * @return	返回组合后的list
	 */
	public static <T> List<Set<T>> combination(List<Set<T>> list, Set<T> preSet, Integer index) {
		Set<T> collections = list.get(index);
		List<Set<T>> result=new ArrayList<Set<T>>();
		for (T t : collections) {
			Set<T> set = new HashSet<T>();
			set.addAll(preSet);
			set.remove(t);
			set.add(t);
			if (index + 1 == list.size()) {
				result.add(set);
			} else {
				result.addAll(combination(list, set, index + 1));
			}
		}
		return result;
	}
}
