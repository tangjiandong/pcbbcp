package com.app.utils.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
/**
 * Vo工具类
 * @author admin
 *
 */
public class VoHelp {
	/**
	 * @param obj
	 *            实体对象
	 * @param sql
	 * @return map
	 * @throws Exception
	 */
	public static Map setObjectModelForSql(Object obj) {
		if (obj == null) {
			return null;
		}
		Map map = new HashMap();
		// 获得对象的类型
		Class classType = obj.getClass();
		// 获得对象的所有属性
		Field[] fields = classType.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			// 获取数组中对应的属性
			Field field = fields[i];
			String fieldName = field.getName();
			String stringLetter = fieldName.substring(0, 1).toUpperCase();
			String getName = "get" + stringLetter + fieldName.substring(1);
			Method getMethod;
			try {
				getMethod = classType.getMethod(getName, new Class[] {});
				Object objValue = getMethod.invoke(obj);
				if (objValue != null){
					map.put(fieldName, objValue);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return map;
	}
}
