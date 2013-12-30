package com.app.jdbc.dao;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.app.jdbc.springframework.jdbc.DBJdbcDaoSupport;


@SuppressWarnings("all")
@Repository("jdbcBaseDaoImpl")
public class JdbcBaseDaoImpl extends DBJdbcDaoSupport implements JdbcBaseDao {

	public int baseExecute(String sql, Vector params)
			throws DataAccessException {
		 return super.getJdbcTemplate().db_execute(sql, params);
	}


	public List baseList(String sql, Vector params, int startRow, int endRow)
			throws DataAccessException {
		return super.getJdbcTemplate().db_query(sql, params, startRow, endRow);
	}

	public Vector baseExecuteStoredProcedure(String callsql, Vector in_params,
			Vector out_params) throws DataAccessException {
		return super.getJdbcTemplate().executeStoredProcedure(callsql, in_params, out_params,0);
	}
	public Vector baseExecuteStoredProcedure(String callsql, Vector in_params,
			Vector out_params,int in_out) throws DataAccessException {
		return super.getJdbcTemplate().executeStoredProcedure(callsql, in_params, out_params,in_out);
	}

	/**
	 * 获取数据连接
	 * @return
	 * @throws DataAccessException
	 */
	public  Connection getConnection()  throws DataAccessException{
        return 	super.getConnection();
 }


	/**
	 * 关闭数据连接
	 * @return
	 * @throws DataAccessException
	 */
	public  void releaseConnection(Connection con) throws DataAccessException{
		 super.releaseConnection(con);
	}
	
	/**
	 * 获取DBJdbcTemplate 操作JDB模板
	 * @return
		public  DBJdbcTemplate getJdbcTemplate() throws DataAccessException{
			return super.getJdbcTemplate();
		}
	*/
}
