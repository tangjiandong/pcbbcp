package com.app.jdbc.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.app.jdbc.dao.JdbcBaseDao;
import com.app.jdbc.springframework.jdbc.DBJdbcTemplate;
import com.app.jdbc.util.Pager;

@SuppressWarnings("all")
@Service("jdbcBaseServiceImpl")
public   class JdbcBaseServiceImpl  implements JdbcBaseService{
	@Resource(name="jdbcBaseDaoImpl")
	private JdbcBaseDao baseDao;
     /*****私有方法begin *************************************/
	/**
	 * 执行SQL 
	 * @param sql 传过来的sql语句
	 * @param params 传入参数
	 * @return int  
	 * @throws DataAccessException
	 */
	private  int baseExecute(String sql, Vector params)throws DataAccessException{
		 return baseDao.baseExecute(sql,params);
	}

	/**
	 * 
	 * @param sql 传过来的sql语句
	 * @param params  传入参数
	 * @param startRow 开始行
	 * @param endRow 结束行
	 * @return List HashMap格式list结果集
	 * @throws DataAccessException
	 */
	private  List baseList(String sql,Vector params, int startRow,int endRow)throws DataAccessException{
		return  baseDao.baseList(sql, params, startRow, endRow);
	}


	
	/**
	 * sql2005 2008 
	 *demo  call newjobs(?,?.....)
	 *采用CallableStatement执行存储过程
	 *调用存储过程返回 输出参数 结果集合
	 * 
	 * @param callsql
	 *            传过来的存储过程带参数   UP_GetRecordByPage (?,?,?,?,?,?.....)
	 * @param params
	 *            传入参数
	 * @return Vector 格式为字符集合
	 */
	private  Vector baseExecuteStoredProcedure(String callsql,Vector in_params,Vector out_params) throws DataAccessException{
		return baseDao.baseExecuteStoredProcedure(callsql, in_params, out_params);
	}

	private  Vector baseExecuteStoredProcedure(String callsql,Vector in_params,Vector out_params,int in_out) throws DataAccessException{
		return baseDao.baseExecuteStoredProcedure(callsql, in_params, out_params,in_out);
	}
	
	/**
	 * 返回查询总数的sql语句字符串
	 * 
	 * @param sql
	 *            传入查询的sql语句
	 * @return 查询总数的sql语句字符串
	 */
	private String getCountSql(String sql) {
		if (StringUtils.isEmpty(sql)) {
			return null;
		}
		sql = sql.toLowerCase();
		StringBuilder sb = new StringBuilder();
		sb.append("select count(1) as num_no from ( ");
		if (sql.lastIndexOf(")") < sql.lastIndexOf("order by")) {
			sql = sql.substring(0, sql.lastIndexOf("order by"));
		}
		sb.append(sql);
		sb.append(" ) z");

		return sb.toString();
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
	private String setInsertOrUpdateSql(String tableName, List cols, String flag) {
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
					sql.append("?)");
				} else {
					sql.append("?,");
				}
			}
		} else if ("update".equals(flag)) {
			sql.append("update ");
			sql.append(tableName);
			sql.append(" set  ");
			for (int i = 0; i < cols.size(); ++i) {
				sql.append((String) cols.get(i));
				sql.append("=?");
				if (i == cols.size() - 1)
					continue;
				sql.append(", ");
			}
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
	private void changerMap(Map objMap, List cols, Vector params) {
		Object[] strs = objMap.keySet().toArray();
		for (Object key : strs) {
			Object value = objMap.get(key);
			cols.add(key);
			params.add(value);
		}
	}

	/**
	 * @param <T>
	 * @param classType
	 *            对象的类型
	 * @param map
	 * @return T 返回泛型对象
	 * @throws Exception
	 */
	private <T> T setObjectModelForMap(Class<T> classType, Map map)
			throws Exception {
		if (map == null) {
			return null;
		}
		// 获得对象的类型
		// Class classType =arg;
		// System.out.println("********************begin******************************");
		// 通过默认构造方法去创建一个新的对象，getConstructor的视其参数决定调用哪个构造方法
		// Object objectCopy = classType.getConstructor(new Class[]
		// {}).newInstance(new Object[] {});
		// 创建一个新的对象
		T objectCopy = classType.newInstance();
		// 获得对象的所有属性
		Field[] fields = classType.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			// 获取数组中对应的属性
			Field field = fields[i];
			String fieldName = field.getName(); // 属性名称
			String value = null;
			try {
				Object temp_value = map.get(fieldName.toLowerCase());// 从Map对象获取属性值value
				if (temp_value == null) {
					// System.out.println("没有值的属性： "+fieldName.toLowerCase());
					continue;
				}
				value = temp_value.toString();// 获取值

			} catch (Exception e) {
				throw e;
			}

			String stringLetter = fieldName.substring(0, 1).toUpperCase();
			String setName = "set" + stringLetter + fieldName.substring(1);
			Method setMethod = classType.getMethod(setName,
					new Class[] { field.getType() });
			// System.out.println("fieldName: "+fieldName);
			// 调用源对象的 getXXX（）方法

			// 根据 字段类型 设置值
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String typeName = field.getType().getName();
			if (null != value && "" != value) {
				try {
					if (typeName.equals("java.lang.String")) {
						setMethod.invoke(objectCopy, value);

					} else if (typeName.equals("java.lang.Long")) {
						setMethod.invoke(objectCopy, Long.parseLong(value));

					} else if (typeName.equals("long")) {
						setMethod.invoke(objectCopy, Long.parseLong(value));

					} else if (typeName.equals("java.util.Date")) {
						setMethod.invoke(objectCopy, format.parse(value));

					} else if (typeName.equals("java.math.BigDecimal")) {
						setMethod.invoke(objectCopy,
								BigDecimal.valueOf(Long.parseLong(value)));

					} else if (typeName.equals("java.lang.Double")) {
						setMethod.invoke(objectCopy,
								java.lang.Double.parseDouble(value));

					} else if (typeName.equals("double")) {
						setMethod.invoke(objectCopy,
								java.lang.Double.parseDouble(value));

					} else if (typeName.equals("java.lang.Integer")) {
						setMethod.invoke(objectCopy,
								java.lang.Integer.parseInt(value));
					} else if (typeName.equals("int")) {
						setMethod.invoke(objectCopy,
								java.lang.Integer.parseInt(value));
					}

				} catch (Exception e) {
					throw e;
				}
			}
		}

		return objectCopy;
	}
	/*****私有方法end   ******************************/
	public List list(String sql) throws DataAccessException {
		if (StringUtils.isEmpty(sql)) {
			return null;
		}
		List list = null;
		list = baseList(sql, null, -1, -1);

		return list;
		
	}


	public List list(String sql, Vector params) throws DataAccessException {
		if (StringUtils.isEmpty(sql)) {
			return null;
		}
		if (params == null || params.size() == 0) {
			return null;
		}
		List list = null;

		list = baseList(sql, params, -1, -1);

		return list;
	}

	public List list(String sql, Pager pager) throws DataAccessException {
		if (StringUtils.isEmpty(sql)) {
			return null;
		}
		if (pager == null) {
			return null;
		}
		if (pager.getPageSize() <= 0) {
			return null;
		}
		List list = null;

		int totalRows = 0;
		List list_count = baseList(getCountSql(sql), null, -1, -1);
		if (list_count.size() > 0) {
			Map temp_map = (Map) list_count.get(0);
			totalRows = Integer.parseInt(temp_map.get("num_no").toString());
		}

		pager.setTotalRows(totalRows);// 统计多少行数据
		pager.setStartRow(pager.getCurrentPage() * pager.getPageSize()
				- pager.getPageSize());// 改变pager对象 开始行数

		list = baseList(sql, null, pager.getStartRow(), pager.getCurrentPage()
				* pager.getPageSize());

		return list;
	}

	public List list(String sql, Vector params, Pager pager)
			throws DataAccessException {
		if (StringUtils.isEmpty(sql)) {
			return null;
		}
		if (params == null || params.size() == 0 || pager == null) {
			return null;
		}
		List list = null;

		int totalRows = 0;
		List list_count = baseList(getCountSql(sql), params, -1, -1);
		if (list_count.size() > 0) {
			Map temp_map = (Map) list_count.get(0);
			totalRows = Integer.parseInt(temp_map.get("num_no").toString());
		}
		// 如果 pageSize传入为 -1 表示 每页大小由浏览器高度得出
		pager.setTotalRows(totalRows);// 统计多少行数据

		pager.setStartRow(pager.getCurrentPage() * pager.getPageSize()
				- pager.getPageSize());// 改变pager对象 开始行数

		list = baseList(sql, params, pager.getStartRow(),
				pager.getCurrentPage() * pager.getPageSize());

		return list;
	}

	public HashMap obj(String sql) throws DataAccessException {
		if (StringUtils.isEmpty(sql)) {
			return null;
		}
		HashMap obj = null;
		List list = baseList(sql, null, -1, -1);
		if (list == null || list.size() == 0) {
			return null;
		}
		obj = (HashMap) list.get(0);

		return obj;
	}

	public HashMap obj(String sql, Vector params) throws DataAccessException {
		if (StringUtils.isEmpty(sql))
			return null;
		if (params == null || params.size() == 0)
			return null;
		HashMap obj = null;

		List list = baseList(sql, params, -1, -1);
		if (list == null || list.size() == 0) {
			return null;
		}
		obj = (HashMap) list.get(0);

		return obj;
		
	}

	public int getCount(String sql, Vector params) throws DataAccessException {
		if (StringUtils.isEmpty(sql)) {
			return 0;
		}
		if (params == null || params.size() == 0) {
			return 0;
		}
		int count = 0;

		List list_count = baseList(getCountSql(sql), params, -1, -1);
		if (list_count.size() > 0) {
			Map temp_map = (Map) list_count.get(0);
			count = Integer.parseInt(temp_map.get("num_no").toString());
		}

		return count;
	}

	
	/**
	 * 通过序列名获取序列值
	 * @param seq_name
	 * @return
	 * @throws DataAccessException
	 */
	public long getSeqBySeqName(String seq_name)throws DataAccessException{
		String seq_sql="select "+seq_name+".nextval as seq_num from dual";
		return Long.parseLong(obj(seq_sql).get("seq_num").toString());		
	}
	public Vector executeStoredProcedure(String callsql, Vector in_params,
			Vector out_params) throws DataAccessException {

		return baseExecuteStoredProcedure(callsql, in_params, out_params);
	}
	public Vector executeStoredProcedure(String callsql, Vector in_params,
			Vector out_params,int in_out) throws DataAccessException {
		return baseExecuteStoredProcedure(callsql, in_params, out_params,in_out);
	}

	public boolean add(String tableName, List cols, Vector params)
			throws DataAccessException {
		if (tableName == null || tableName.trim().equals("")) {
			return false;
		}
		if (cols == null || cols.size() == 0) {
			return false;
		}
		if (params == null || params.size() == 0) {
			return false;
		}
		int b = -1;
		String sql = setInsertOrUpdateSql(tableName, cols, "insert");// 设置插入语句
		b = baseExecute(sql, params);

		return b > -1;
	}

	public boolean add(String tableName, Map objMap) throws DataAccessException {
		if (tableName == null || tableName.trim().equals("")) {
			return false;
		}
		if (objMap == null || objMap.size() == 0) {
			return false;
		}
		List cols = new ArrayList();
		Vector params = new Vector();
		changerMap(objMap, cols, params);// 把Map 对象改变为 列名集合和参数值集合
		if (cols == null || cols.size() == 0) {
			return false;
		}
		if (params == null || params.size() == 0) {
			return false;
		}
		int b = -1;
		String sql = setInsertOrUpdateSql(tableName, cols, "insert");// 设置插入语句
		b = baseExecute(sql, params);

		return b > -1;
	}
/**
	public boolean update(String tableName, List cols, Vector params,
			String condition_SQL) throws DataAccessException {
		if (tableName == null || tableName.trim().equals("")) {
			return false;
		}
		if (cols == null || cols.size() == 0) {
			return false;
		}
		if (params == null || params.size() == 0) {
			return false;
		}
		int b = -1;
		String sql = setInsertOrUpdateSql(tableName, cols, "update");// 设置插入语句
		b = baseExecute(sql + condition_SQL, params);

		return b > -1;
	}
*/
	public boolean update_condition(String tableName, List cols, Vector params,
			String condition_SQL, Object... condition_params)
			throws DataAccessException {
		if (tableName == null || tableName.trim().equals("")) {
			return false;
		}
		if (cols == null || cols.size() == 0) {
			return false;
		}
		if (params == null || params.size() == 0) {
			return false;
		}
		int b = -1;

		String sql = setInsertOrUpdateSql(tableName, cols, "update");// 设置插入语句
		// 设置条件SQL语句中的值
		for (Object obj : condition_params) {
			params.add(obj);
		}
		b = baseExecute(sql + condition_SQL, params);

		return b > -1;
	}

	public boolean update(String tableName, List cols, Vector params,
			String condition_SQL, Vector condition_params)
			throws DataAccessException {
	
		if (tableName == null || tableName.trim().equals("")) {
			return false;
		}
		if (cols == null || cols.size() == 0) {
			return false;
		}
		if (params == null || params.size() == 0) {
			return false;
		}
		int b = -1;

		String sql = setInsertOrUpdateSql(tableName, cols, "update");// 设置插入语句
		// 设置条件SQL语句中的值
		if (condition_params != null) {
			for (int i = 0; i < condition_params.size(); i++) {
				params.add(condition_params.get(i));
			}
		}
		b = baseExecute(sql + condition_SQL, params);

		return b > -1;
	}

	public boolean update(String tableName, Map objMap, String condition_SQL,
			Vector condition_params) throws DataAccessException {
		if (tableName == null || tableName.trim().equals("")) {
			return false;
		}
		if (objMap == null || objMap.size() == 0) {
			return false;
		}
		List cols = new ArrayList();
		Vector params = new Vector();
		changerMap(objMap, cols, params);// 把Map 对象改变为 列名集合和参数值集合
		if (cols == null || cols.size() == 0) {
			return false;
		}
		if (params == null || params.size() == 0) {
			return false;
		}
		int b = -1;

		// 设置条件SQL语句中的值
		if (condition_params != null) {
			for (int i = 0; i < condition_params.size(); i++) {
				params.add(condition_params.get(i));
			}
		}
		String sql = setInsertOrUpdateSql(tableName, cols, "update");// 设置插入语句
		b = baseExecute(sql + condition_SQL, params);

		return b > -1;
	}

	public boolean update_condition(String tableName, Map objMap,
			String condition_SQL, Object... condition_params)
			throws DataAccessException {
		if (tableName == null || tableName.trim().equals("")) {
			return false;
		}
		if (objMap == null || objMap.size() == 0) {
			return false;
		}
		List cols = new ArrayList();
		Vector params = new Vector();
		changerMap(objMap, cols, params);// 把Map 对象改变为 列名集合和参数值集合
		if (cols == null || cols.size() == 0) {
			return false;
		}
		if (params == null || params.size() == 0) {
			return false;
		}
		int b = -1;

		String sql = setInsertOrUpdateSql(tableName, cols, "update");// 设置插入语句
		// 设置条件SQL语句中的值
		for (Object obj : condition_params) {
			params.add(obj);
		}

		b = baseExecute(sql + condition_SQL, params);

		return b > -1;
	}
/*
	public boolean update(String tableName, Map objMap, String condition_SQL)
			throws DataAccessException {
		if (tableName == null || tableName.trim().equals("")) {
			return false;
		}
		if (objMap == null || objMap.size() == 0) {
			return false;
		}
		List cols = new ArrayList();
		Vector params = new Vector();
		changerMap(objMap, cols, params);// 把Map 对象改变为 列名集合和参数值集合
		if (cols == null || cols.size() == 0) {
			return false;
		}
		if (params == null || params.size() == 0) {
			return false;
		}

		int b = -1;

		String sql = setInsertOrUpdateSql(tableName, cols, "update");// 设置插入语句
		b = baseExecute(sql + condition_SQL, params);

		return b > -1;
	}
*/
	public boolean delete(String sql, Vector params) throws DataAccessException {
		return baseExecute(sql, params)>-1;
	}

	public boolean execute(String sql, Vector params)
			throws DataAccessException {
		return baseExecute(sql, params)>-1;
	}
	public int executeNum(String sql, Vector params)
			throws DataAccessException {
		return baseExecute(sql, params);
	}

	public boolean execute(String sql) throws DataAccessException {
		return baseExecute(sql,null)>-1;
	}

	public <T> T getObj(Class<T> classType, String sql, Vector params)
			throws DataAccessException {
		Map map = obj(sql, params);
		T obj = null;
		if (map != null) {
			try {
				obj = setObjectModelForMap(classType, map);
				return obj;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	public <T> List<T> getTlist(Class<T> classType, String sql)
			throws DataAccessException {
		List<T> list = new ArrayList<T>();
		List temp_list = list(sql);
		for (Object object : temp_list) {
			Map map = (Map) object;
			try {
				T t = setObjectModelForMap(classType, map);
				list.add(t);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		return list;
	}

	public <T> List<T> getTlist(Class<T> classType, String sql, Vector params)
			throws DataAccessException {
		List<T> list = new ArrayList<T>();
		List temp_list = list(sql, params);
		for (Object object : temp_list) {
			Map map = (Map) object;
			try {
				T t = setObjectModelForMap(classType, map);
				list.add(t);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		return list;
	}


	public <T> List<T> getTlist(Class<T> classType, String sql, Vector params,
			Pager pager) throws DataAccessException {
		List<T> list = new ArrayList<T>();
		List temp_list = list(sql, params, pager);
		for (Object object : temp_list) {
			Map map = (Map) object;
			try {
				T t = setObjectModelForMap(classType, map);
				list.add(t);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		return list;
	}

	public <T> List<T> getTlist(Class<T> classType, String sql, Pager pager)
			throws DataAccessException {
		List<T> list = new ArrayList<T>();
		List temp_list = list(sql, pager);
		for (Object object : temp_list) {
			Map map = (Map) object;
			try {
				T t = setObjectModelForMap(classType, map);
				list.add(t);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		return list;
	}
	/**
	 * 获取数据连接
	 * @return
	 * @throws DataAccessException
	 */
	public  Connection getConnection()  throws DataAccessException{
        return baseDao.getConnection();
 }


	/**
	 * 关闭数据连接
	 * @return
	 * @throws DataAccessException
	 */
	public  void releaseConnection(Connection con) throws DataAccessException{
		baseDao.releaseConnection(con);
	}
	
	
	/**
	 * 获取DBJdbcTemplate 操作JDB模板
	 * @return
	 */
	public  DBJdbcTemplate getJdbcTemplate() throws DataAccessException{
		return baseDao.getJdbcTemplate();
	}
	
}
