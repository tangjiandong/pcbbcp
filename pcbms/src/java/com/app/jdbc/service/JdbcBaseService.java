package com.app.jdbc.service;



import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.springframework.dao.DataAccessException;

import com.app.jdbc.util.Pager;


@SuppressWarnings("all")
public interface JdbcBaseService {
	/**
	 * 根据传入sql语句返回HashMap格式的list结果集
	 * 
	 * @param sql
	 *            传过来的sql语句
	 * @return List HashMap格式list结果集
	 */

	
	public List list(String sql) throws DataAccessException;

	/**
	 * 根据传入sql语句,传入参数返回HashMap格式的list结果集 sql语句必须为 as格式如 select id as id, name as
	 * name from demo
	 * 
	 * @param sql
	 *            传过来的sql语句
	 * @param params
	 *            传入参数
	 * @return List HashMap格式list结果集
	 */

	public List list(String sql, Vector params) throws DataAccessException;

	/**
	 * 根据传入sql语句，每页显示行数返回HashMap格式的list结果集 sql语句必须为 as格式如 select id as id, name
	 * as name from demo
	 * 
	 * @param sql
	 *            传过来的sql语句
	 * @param pageSize
	 *            每页显示行数
	 * @return List list结果集
	 */

	public List list(String sql, Pager pager) throws DataAccessException;

	/**
	 * 根据传入sql语句，传入参数，每页显示行数(-1 表示 每页大小由浏览器高度得出)返回HashMap格式的list结果集 sql语句必须为
	 * as格式如 select id as id, name as name from demo
	 * 
	 * @param sql
	 *            传过来的sql语句
	 * @param params
	 *            传入参数
	 * @param Pager
	 *            分页 对象
	 * @return List list结果集
	 */
	public List list(String sql, Vector params, Pager pager)
			throws DataAccessException;

	/**
	 * 根据传入sql语句，返回一条HashMap格式记录
	 * 
	 * @param sql
	 *            传过来的sql语句
	 * @return HashMap 键值对记录
	 */

	public HashMap obj(String sql) throws DataAccessException;

	/**
	 * 根据传入sql语句，传入参数，返回一条HashMap格式记录
	 * 
	 * @param sql
	 *            传过来的sql语句
	 * @param params
	 *            传入参数
	 * @return HashMap 键值对记录
	 */
	public HashMap obj(String sql, Vector params) throws DataAccessException;

	/**
	 * 返回查询总数的sql语句字符串
	 * 
	 * @param sql
	 *            传入查询的sql语句
	 * @return 查询总数的sql语句字符串
	 */

	public int getCount(String sql, Vector params) throws DataAccessException;

	/***************************************************************************************
	 * 
	 * ****************************
	 * 存储过程操作************************************************
	 * 
	 */

	/**
	 * sql2005 2008 demo call newjobs(?,?.....) 采用CallableStatement执行存储过程
	 * 调用存储过程返回 输出参数 结果集合
	 * 
	 * @param callsql
	 *            传过来的存储过程带参数 UP_GetRecordByPage (?,?,?,?,?,?.....)
	 * @param params
	 *            传入参数
	 * @return Vector 格式为字符集合
	 */
	public Vector executeStoredProcedure(String callsql, Vector in_params,
			Vector out_params) throws DataAccessException;
	
	public Vector executeStoredProcedure(String callsql, Vector in_params,
			Vector out_params,int in_out) throws DataAccessException;

	/***************************************************************************************
	 * 
	 * ****************************
	 * 存储过程操作************************************************
	 * 
	 */

	/***************************************************************************************
	 * 
	 * ****************************
	 * 增加操作*************************************************
	 * 
	 */
	/**
	 * 增加操作 操作成功返回 true 否返回 false
	 * 
	 * @param tableName
	 *            表名
	 * @param cols
	 *            字段列表
	 * @param params
	 *            字段值列表
	 */
	public boolean add(String tableName, List cols, Vector params)
			throws DataAccessException;

	/**
	 * 增加操作 操作成功返回 true 否返回 false
	 * 
	 * @param tableName
	 *            表名
	 * @param objMap
	 *            Map 封装参数对象
	 */
	public boolean add(String tableName, Map objMap) throws DataAccessException;

	/**
	 * *************************************************************************
	 * **************************** 修改操作*************************************
	 */

	/**
	 * 修改操作 操作成功返回 true 否返回 false
	 * 
	 * @param tableName
	 *            表名
	 * @param cols
	 *            字段列表
	 * @param params
	 *            字段值列表
	 * @param condition_SQL
	 *            条件SQL语句 where t.id=12 and t.name='zhangsan' .....
	
	public boolean update(String tableName, List cols, Vector params,
			String condition_SQL) throws DataAccessException;
 */
	/**
	 * 修改操作 操作成功返回 true 否返回 false
	 * 
	 * @param tableName
	 *            表名
	 * @param cols
	 *            字段列表
	 * @param params
	 *            字段值列表
	 * @param condition_SQL
	 *            条件SQL语句 where t.id=? and t.name=? .....
	 * @param condition_params
	 *            条件参数值列表(可变参数) where t.id=? and t.name=? ..... 其中?中值
	 */
	public boolean update_condition(String tableName, List cols, Vector params,
			String condition_SQL, Object... condition_params)
			throws DataAccessException;

	/**
	 * 修改操作 操作成功返回 true 否返回 false
	 * 
	 * @param tableName
	 *            表名
	 * @param cols
	 *            字段列表
	 * @param params
	 *            字段值列表
	 * @param condition_SQL
	 *            条件SQL语句 where t.id=? and t.name=? .....
	 * @param condition_params
	 *            条件参数值列表(可变参数) where t.id=? and t.name=? ..... 其中?中值
	 */
	public boolean update(String tableName, List cols, Vector params,
			String condition_SQL, Vector condition_params)
			throws DataAccessException;

	/**
	 * 修改操作 操作成功返回 true 否返回 false
	 * 
	 * @param tableName
	 *            表名
	 * @param objMap
	 *            Map 封装参数对象
	 * @param condition_SQL
	 *            条件SQL语句 where t.id=? and t.name=? .....
	 * @param condition_params
	 *            条件参数值列表(可变参数) where t.id=? and t.name=? ..... 其中?中值
	 */
	public boolean update(String tableName, Map objMap, String condition_SQL,
			Vector condition_params) throws DataAccessException;

	/**
	 * 修改操作 操作成功返回 true 否返回 false
	 * 
	 * @param tableName
	 *            表名
	 * @param objMap
	 *            Map 封装参数对象
	 * @param condition_SQL
	 *            条件SQL语句 where t.id=? and t.name=? .....
	 * @param condition_params
	 *            条件参数值列表(可变参数) where t.id=? and t.name=? ..... 其中?中值
	 */
	public boolean update_condition(String tableName, Map objMap,
			String condition_SQL, Object... condition_params)
			throws DataAccessException;

	/**
	 * 修改操作 操作成功返回 true 否返回 false
	 * 
	 * @param tableName
	 *            表名
	 * @param objMap
	 *            Map 封装参数对象
	 * @param condition_SQL
	 *            条件SQL语句 where t.id=12 and t.name='zhangsan' .....
	 
	public boolean update(String tableName, Map objMap, String condition_SQL)
			throws DataAccessException;
*/
	/**
	 * 删除操作 操作成功返回 true 否返回 false
	 * 
	 * @param cols
	 *            字段列表
	 * @param params
	 *            字段值列表
	 */
	public boolean delete(String sql, Vector params) throws DataAccessException;

	/**
	 * 执行SQL语句 操作成功返回 true 否返回 false
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数列表
	 */
	public boolean execute(String sql, Vector params)
			throws DataAccessException;
	
	/**
	 * 执行SQL语句 操作成功返回 true 否返回 false
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数列表
	 */
	public int executeNum(String sql, Vector params)
			throws DataAccessException;

	/**
	 * 操作成功返回 true 否返回 false
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数列表
	 */
	public boolean execute(String sql) throws DataAccessException;

	/**
	 * 
	 * **************************泛型查询结果begin***************
	 * 
	 */

	/**
	 * 根据传入sql语句，传入参数，返回一条HashMap格式记录
	 * 
	 * @param classType
	 *            传过来的对象类型 例如User.class
	 * @param sql
	 *            传过来的sql语句
	 * @param params
	 *            传入参数
	 * @return T 返回泛型对象
	 */
	public <T> T getObj(Class<T> classType, String sql, Vector params)
			throws DataAccessException;

	/**
	 * 根据传入sql语句和对象类型返回HashMap格式的返回泛型集合list结果集
	 * 
	 * @param classType
	 *            传过来的对象类型 例如User.class
	 * @param sql
	 *            传过来的sql语句
	 * @return List<T>返回泛型集合list
	 */
	public <T> List<T> getTlist(Class<T> classType, String sql)
			throws DataAccessException;

	/**
	 * 根据传入sql语句和对象类型返回HashMap格式的返回泛型集合list结果集
	 * 
	 * @param classType
	 *            传过来的对象类型 例如User.class
	 * @param sql
	 *            传过来的sql语句
	 * @param params
	 *            传入参数 * @return List<T>返回泛型集合list
	 */

	public <T> List<T> getTlist(Class<T> classType, String sql, Vector params)
			throws DataAccessException;

	/**
	 *根据传入sql语句和对象类型返回HashMap格式的返回泛型集合list结果集
	 * 
	 * @param classType
	 *            传过来的对象类型 例如User.class
	 * @param sql
	 *            传过来的sql语句
	 * @param params
	 *            传入参数
	 * @param Pager
	 *            分页 对象
	 * @return List<T>返回泛型集合list
	 */
	public <T> List<T> getTlist(Class<T> classType, String sql, Vector params,
			Pager pager) throws DataAccessException;

	/**
	 *根据传入sql语句和对象类型返回HashMap格式的返回泛型集合list结果集
	 * 
	 * @param classType
	 *            传过来的对象类型 例如User.class
	 * @param sql
	 *            传过来的sql语句
	 * @param params
	 *            传入参数
	 * @return List<T>返回泛型集合list
	 */
	public <T> List<T> getTlist(Class<T> classType, String sql, Pager pager)
			throws DataAccessException;

	/**
	 * 
	 * **************************泛型查询结果end***************
	 * 
	 */

	/**
	 * 获取数据连接
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	public Connection getConnection() throws DataAccessException;

	/**
	 * 关闭数据连接
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	public void releaseConnection(Connection con) throws DataAccessException;
    
	/**
	 * 通过序列名获取序列值
	 * @param seq_name
	 * @return
	 * @throws DataAccessException
	 */
	public long getSeqBySeqName(String seq_name)throws DataAccessException;
	
}
