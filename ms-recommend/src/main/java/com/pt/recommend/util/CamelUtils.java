package com.pt.recommend.util;

/**
 * @ClassName: NameUtils
 * @Description: 驼峰和下划线相互转换
 * @author 谯雕
 * @date 2018年11月21日
 *
 */
public class CamelUtils {

	/**
	 * @Title: underscoreName
	 * @Description: 驼峰转下划线
	 * @param camelCaseName
	 * @return
	 */
	public static String underscoreName(String camelCaseName) {
		StringBuffer buffer = new StringBuffer();
		if (camelCaseName != null && camelCaseName.length() > 0) {
			buffer.append(camelCaseName.substring(0, 1).toLowerCase());
			for (int i = 1; i < camelCaseName.length(); i++) {
				char ch = camelCaseName.charAt(i);
				if (Character.isUpperCase(ch)) {
					buffer.append("_");
					buffer.append(Character.toLowerCase(ch));
				} else {
					buffer.append(ch);
				}
			}
		}
		return buffer.toString();
	}

	/**
	 * @Title: camelCaseName
	 * @Description: 下划线转驼峰
	 * @param underscoreName
	 * @return
	 */
	public static String camelCaseName(String underscoreName) {
		StringBuffer buffer = new StringBuffer();
		if (underscoreName!=null&&underscoreName.length()>0) {
			Boolean flag = false;
			for (int i = 0; i < underscoreName.length(); i++) {
				char ch = underscoreName.charAt(i);
				if ("_".charAt(0) == ch) {
					flag = true;
				} else {
					if (flag) {
						buffer.append(Character.toUpperCase(ch));
						flag = false;
					}else {
						buffer.append(Character.toLowerCase(ch));
					}
				}
			}
		}
		return buffer.toString();
	}
}
