package com.pt.recommend.util;

public enum PtEnum {

	CODE_01("01", "正常,有返回值"),
	CODE_02("02", "正常,无返回值"),
	CODE_03("03", "未查询到相应数据"),
	CODE_04("04", "保存数据出错");

	private final String code;
	private final String desc;

	private PtEnum(String code, String desc) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	/**
	 * @Title: getEnumDescByKey
	 * @Description: 通过枚举类型的key值获取该枚举类型的描述，
	 * @param key
	 * @return
	 */
	public static String getEnumDescByKey(String key) {
		for (PtEnum item : PtEnum.values()) {
			if (key.equals(item.getCode())) {
				return item.getDesc();
			}
		}
		return "";
	}
}
