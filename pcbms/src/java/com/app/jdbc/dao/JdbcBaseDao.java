package com.app.jdbc.dao;



import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.app.jdbc.springframework.jdbc.DBJdbcTemplate;


@SuppressWarnings("all")
public interface JdbcBaseDao {



	/**
	 * 执行SQL 
	 * @param sql 传过来的sql语句
	 * @param params 传入参数
	 * @return int  
	 * @throws DataAccessException
	 */
	public  int baseExecute(String sql, Vector params)throws DataAccessException;

	/**
	 * 
	 * @param sql 传过来的sql语句
	 * @param params  传入参数
	 * @param startRow 开始行
	 * @param endRow 结束行
	 * @return List HashMap格式list结果集
	 * @throws DataAccessException
	 */
	public  List baseList(String sql,Vector params, int startRow,int endRow)throws DataAccessException;


	
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
	public  Vector baseExecuteStoredProcedure(String callsql,Vector in_params,Vector out_params) throws DataAccessException;

	public Vector baseExecuteStoredProcedure(String callsql, Vector in_params,
			Vector out_params,int in_out) throws DataAccessException;
	/**
	 * 获取数据连接
	 * @return
	 * @throws DataAccessException
	 */
	public  Connection getConnection()  throws DataAccessException;


	/**
	 * 关闭数据连接
	 * @return
	 * @throws DataAccessException
	 */
	public  void releaseConnection(Connection con) throws DataAccessException;
	
	/**
	 * 获取DBJdbcTemplate 操作JDB模板
	 * @return
	 */
	public  DBJdbcTemplate getJdbcTemplate() throws DataAccessException;
		
		
}
