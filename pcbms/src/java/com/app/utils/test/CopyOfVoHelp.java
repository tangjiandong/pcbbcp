package com.app.utils.test;



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@SuppressWarnings("all")
/**
 * Vo工具类
 * @author admin
 *
 */
public class CopyOfVoHelp {
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
				if (objValue != null)
					map.put(fieldName, objValue);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return map;
	}
	
    /**
     * 获取实体对象属性  map>key:fiedname value:fiedname
     * @param obj
     * @return
     */
	public static Map setObjectModelForMap(Object obj) {
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
			try {
				map.put(fieldName, fieldName);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return map;
	}
	
	
	/**
	 * 根据表名和列名封装执行SQL语句
	 * 
	 * @param tableName
	 *            表名
	 * @param cols
	 *            列名结合List <String>
	 * @param flag
	 *            标识为insert 还是 update
	 * @return String
	 */
	public static String setInsertOrUpdateMyBatisSql(String tableName, List cols, String flag) {
		// 封装SQL语句
		StringBuffer sql = new StringBuffer("");
		// 插入SQL
		if ("insert".equals(flag)) {
			sql.append(" insert into ");
			sql.append(tableName);
			sql.append(" (");
			for (int i = 0; i < cols.size(); ++i) {
				sql.append((String) cols.get(i));
				if (i == cols.size() - 1) {
					sql.append(")");
				} else {
					sql.append(",");
				}
			}
			sql.append(" values (");
			for (int i = 0; i < cols.size(); ++i) {
				if (i == cols.size() - 1) {
					//sql.append("?)"); #{studentName}
					sql.append("#{"+(String) cols.get(i)+"})");
				} else {
					//sql.append("?,");
					sql.append("#{"+(String) cols.get(i)+"},");
				}
			}
		} else if ("update".equals(flag)) {
			sql.append("update ");
			sql.append(tableName);
			sql.append(" set  ");
			for (int i = 0; i < cols.size(); ++i) {
				sql.append((String) cols.get(i));
				//sql.append("=?");//#{studentSex}
				sql.append("=#{"+(String) cols.get(i)+"}");//#{studentSex}
				if (i == cols.size() - 1)
					continue;
				sql.append(", ");
			}
		}
		return sql.toString();
	}
	
	
	/**
	 * 根据表名和列名封装执行SQL语句
	 * 
	 * @param tableName
	 *            表名
	 * @param cols
	 *            列名结合List <String>
	 * @param flag
	 *            标识为insert 还是 update
	 * @return String
	 */
	public static String setInsertOrUpdateMyBatisSql(String tableName, Map objMap, String flag) {
		// 封装SQL语句
		StringBuffer sql = new StringBuffer("");
		List cols = new ArrayList();
		Vector params = new Vector();
		changerMap(objMap, cols, params);// 把Map 对象改变为 列名集合和参数值集合
		// 插入SQL
		if ("insert".equals(flag)) {
			sql.append(" insert into ");
			sql.append(tableName);
			sql.append(" (");
			for (int i = 0; i < cols.size(); ++i) {
				sql.append((String) cols.get(i));
				if (i == cols.size() - 1) {
					sql.append(")");
				} else {
					sql.append(",");
				}
			}
			sql.append(" values (");
			for (int i = 0; i < cols.size(); ++i) {
				if (i == cols.size() - 1) {
					//sql.append("?)"); #{studentName}
					sql.append("#{"+(String) cols.get(i)+"})");
				} else {
					//sql.append("?,");
					sql.append("#{"+(String) cols.get(i)+"},");
				}
			}
		} else if ("update".equals(flag)) {
			sql.append("update ");
			sql.append(tableName);
			sql.append(" set  ");
			for (int i = 0; i < cols.size(); ++i) {
				sql.append((String) cols.get(i));
				//sql.append("=?");//#{studentSex}
				sql.append("=#{"+(String) cols.get(i)+"}");//#{studentSex}
				if (i == cols.size() - 1)
					continue;
				sql.append(", ");
			}
		}
		return sql.toString();
	}
	
	
	/**
	 * 根据表名和列名封装执行SQL语句
	 * 
	 * @param tableName
	 *            表名
	 * @param cols
	 *            列名结合List <String>
	 * @param flag
	 *            标识为insert 还是 update
	 * @return String
	 */
	public static String setInsertOrUpdateMyBatisSql_APP(String tableName, Map objMap) {
		// 封装SQL语句
		StringBuffer sql = new StringBuffer("");
		List cols = new ArrayList();
		Vector params = new Vector();
		changerMap(objMap, cols, params);// 把Map 对象改变为 列名集合和参数值集合		
//		<if test="comname != null">
//		comname=#{comname},
//		</if>
		for (int i = 0; i < cols.size(); ++i) {
			String name=(String) cols.get(i);
			sql.append("<if test=\""+name+" != null\">\n");
			sql.append(name+"=#{"+name+"},\n");
			sql.append("</if>\n");
		}
		
		return sql.toString();
	}
	
	
	/**
	 * 根据表名和列名封装执行SQL语句
	 * 
	 * @param tableName
	 *            表名
	 * @param cols
	 *            列名结合List <String>
	 * @param flag
	 *            标识为insert 还是 update
	 * @return String
	 */
	public static String setInsertOrUpdateMyBatisSql_Select(String tableName, Map objMap) {
		// 封装SQL语句
		StringBuffer sql = new StringBuffer("");
		List cols = new ArrayList();
		Vector params = new Vector();
		changerMap(objMap, cols, params);// 把Map 对象改变为 列名集合和参数值集合		
//		<if test="comname != null">
//		comname=#{comname},
//		</if>
		for (int i = 0; i < cols.size(); ++i) {
			String name=(String) cols.get(i);
			sql.append("<if test=\""+name+" != null\">\n");
			sql.append("  and "+name+"=#{"+name+"}\n");
			sql.append("</if>\n");
		}
		
		return sql.toString();
	}
	
	/**
	 * 把Map 对象改变为 列名集合和参数值集合
	 * 
	 * @param objMap
	 *            Map 封装参数对象
	 * @param cols
	 *            List 列名集合
	 * @param params
	 *            Vector 参数值集合
	 */
	public static void changerMap(Map objMap, List cols, Vector params) {
		Object[] strs = objMap.keySet().toArray();
		for (Object key : strs) {
			Object value = objMap.get(key);
			cols.add(key);
			params.add(value);
		}
	}
	
	/**
	 * 根据表名和列名封装执行SQL语句
	 * 
	 * @param tableName
	 *            表名
	 * @param cols
	 *            列名结合List <String>
	 * @param flag
	 *            标识为insert 还是 update
	 * @return String
	 */
	public static String setSelectMyBatisSql(String tableName, Map objMap ,String sql_name) {
		// 封装SQL语句
		StringBuffer sql = new StringBuffer("");
		List cols = new ArrayList();
		Vector params = new Vector();
		changerMap(objMap, cols, params);// 把Map 对象改变为 列名集合和参数值集合
		// select SQL
			sql.append(" select  ");

			sql.append(" ");
			for (int i = 0; i < cols.size(); ++i) {
				sql.append(sql_name+(String) cols.get(i));
				if (i == cols.size() - 1) {
					sql.append(" ");
				} else {
					sql.append(",");
				}
			}
			sql.append(" from "+tableName +" ");
		
		return sql.toString();
	}

}
