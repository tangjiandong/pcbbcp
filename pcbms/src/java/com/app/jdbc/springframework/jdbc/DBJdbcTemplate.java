package com.app.jdbc.springframework.jdbc;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterDisposer;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlProvider;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.Assert;

@SuppressWarnings("all")
public class DBJdbcTemplate extends JdbcTemplate implements JdbcOperations {

	public DBJdbcTemplate() {
	}

	public DBJdbcTemplate(DataSource dataSource) {
		setDataSource(dataSource);
		afterPropertiesSet();
	}

	public DBJdbcTemplate(DataSource dataSource, boolean lazyInit) {
		setDataSource(dataSource);
		setLazyInit(lazyInit);
		afterPropertiesSet();
	}

	/**
	 * 执行SQL操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws DataAccessException
	 */
	public int db_execute(final String sql, Vector params)
			throws DataAccessException {
		Connection con = DataSourceUtils.getConnection(getDataSource());
		PreparedStatement stmt = null;
		try {
			Connection conToUse = con;
			if (super.getNativeJdbcExtractor() != null
					&& super.getNativeJdbcExtractor()
							.isNativeConnectionNecessaryForNativeStatements()) {
				conToUse = super.getNativeJdbcExtractor().getNativeConnection(
						con);
			}
			stmt = conToUse.prepareStatement(sql);
			applyStatementSettings(stmt);

			PreparedStatement stmtToUse = stmt;
			if (super.getNativeJdbcExtractor() != null) {
				stmtToUse = super.getNativeJdbcExtractor()
						.getNativePreparedStatement(stmt);
			}
			/************************************** 变化点 begin ********************************************/
			// 替换这个行代码
			// T result = action.doInStatement(stmtToUse);

			int restult = -1;
			// 执行新方法
			SpringDBDAO dbdao = new SpringDBDAO();
			// 设置数据源
			dbdao.setConnection(conToUse);
			try {
				// 执行SQL
				restult = dbdao.execute(sql, params, stmtToUse);
				// 获取警告信息
				handleWarnings(stmt);
			} catch (Exception e) {
				throw new SQLException(e.getMessage());
			}

			/************************************** 变化点 end ********************************************/

			return restult;

		} catch (SQLException ex) {
			// 关闭PreparedStatement
			JdbcUtils.closeStatement(stmt);
			stmt = null;
			// 关闭数据源
			DataSourceUtils.releaseConnection(con, getDataSource());
			con = null;
			throw getExceptionTranslator().translate("StatementCallback", sql,ex);
		} finally {
			// 关闭PreparedStatement
			JdbcUtils.closeStatement(stmt);
			// 关闭数据源
			DataSourceUtils.releaseConnection(con, getDataSource());
		}
	}

	/**
	 * 查询SQL
	 * 
	 * @param sql
	 * @param params
	 * @param startRow
	 * @param endRow
	 * @return
	 * @throws DataAccessException
	 */
	public List db_query(String sql, Vector params, int startRow, int endRow)
			throws DataAccessException {
		Assert.notNull(sql, "SQL must not be null");

		if (logger.isDebugEnabled()) {
			logger.debug("Executing SQL query [" + sql + "]");
		}
		Connection con = DataSourceUtils.getConnection(getDataSource());
		try {
			Connection conToUse = con;
			if (super.getNativeJdbcExtractor() != null&& super.getNativeJdbcExtractor().isNativeConnectionNecessaryForNativeStatements()) {
				conToUse = super.getNativeJdbcExtractor().getNativeConnection(con);
			}

			/************************************** 变化点 begin ********************************************/
				// 执行
				SpringDBDAO dbdao = new SpringDBDAO();
				// 设置数据源
				dbdao.setConnection(conToUse);
				try {
					// 执行SQL
					List list = dbdao.query(sql, params, startRow, endRow);
					// 获取警告信息
					return list;
				} catch (Exception e) {		
					System.err.println("query list err"+e.getMessage());
					throw new SQLException(e.getMessage());
				}
				
			/************************************** 变化点 end ********************************************/

		} catch (SQLException ex) {
		
			// 关闭数据源
			DataSourceUtils.releaseConnection(con, getDataSource());
			con = null;
			throw getExceptionTranslator().translate("StatementCallback", sql,ex);
		} finally {
			// 关闭数据源
			DataSourceUtils.releaseConnection(con, getDataSource());
		}
		

	}
	
	/**
	 * 查询SQL
	 * 
	 * @param sql
	 * @param params
	 * @param startRow
	 * @param endRow
	 * @return
	 * @throws DataAccessException
	 */
	public List db_query20120413(String sql, Vector params, int startRow, int endRow)
			throws DataAccessException {
		Assert.notNull(sql, "SQL must not be null");

		if (logger.isDebugEnabled()) {
			logger.debug("Executing SQL query [" + sql + "]");
		}

		Connection con = DataSourceUtils.getConnection(getDataSource());
		PreparedStatement stmt = null;
		try {
			Connection conToUse = con;
			if (super.getNativeJdbcExtractor() != null
					&& super.getNativeJdbcExtractor()
							.isNativeConnectionNecessaryForNativeStatements()) {
				conToUse = super.getNativeJdbcExtractor().getNativeConnection(
						con);
			}
			stmt = conToUse.prepareStatement(sql);
			applyStatementSettings(stmt);

			PreparedStatement stmtToUse = stmt;
			if (super.getNativeJdbcExtractor() != null) {
				stmtToUse = super.getNativeJdbcExtractor()
						.getNativePreparedStatement(stmt);
			}

			/************************************** 变化点 begin ********************************************/
			ResultSet rs = null;
			try {

				// 执行查詢操作操作
				// rs = stmt.executeQuery(sql);
				ResultSet rsToUse = rs;
				// 执行
				SpringDBDAO dbdao = new SpringDBDAO();
				// 设置数据源
				dbdao.setConnection(conToUse);
				try {
					// 执行SQL
					List list = dbdao.query(sql, params, startRow, endRow,
							stmtToUse, rsToUse);
					// 获取警告信息
					handleWarnings(stmt);
					
					//获取异常信息
					if (super.getNativeJdbcExtractor() != null) {
						rsToUse = super.getNativeJdbcExtractor().getNativeResultSet(rs);
					}
					
					return list;
				} catch (Exception e) {
					throw new SQLException(e.getMessage());
				}
			} finally {
				JdbcUtils.closeResultSet(rs);
			}
			/************************************** 变化点 end ********************************************/

		} catch (SQLException ex) {
			// 关闭PreparedStatement
			JdbcUtils.closeStatement(stmt);
			stmt = null;
			// 关闭数据源
			DataSourceUtils.releaseConnection(con, getDataSource());
			con = null;
			throw getExceptionTranslator().translate("StatementCallback", sql,
					ex);
		} finally {
			// 关闭PreparedStatement
			JdbcUtils.closeStatement(stmt);
			// 关闭数据源
			DataSourceUtils.releaseConnection(con, getDataSource());
		}

	}

	/**
	 * 执行存储过程
	 * 
	 * @param callsql
	 * @param in_params
	 * @param out_params
	 * @return
	 * @throws DataAccessException
	 */
	public Vector executeStoredProcedure(String callsql, Vector in_params,
			Vector out_params,int in_out) throws DataAccessException {

		Connection con = DataSourceUtils.getConnection(getDataSource());
		CallableStatement cs = null;
		try {
			Connection conToUse = con;
			if (super.getNativeJdbcExtractor() != null) {
				conToUse = super.getNativeJdbcExtractor().getNativeConnection(
						con);
			}
			// 执行存储过程
			cs = conToUse.prepareCall(callsql);
			applyStatementSettings(cs);
			CallableStatement csToUse = cs;
			if (super.getNativeJdbcExtractor() != null) {
				csToUse = super.getNativeJdbcExtractor()
						.getNativeCallableStatement(cs);
			}
			/************************************** 变化点 begin ********************************************/
			// 替换这个行代码
			// T result = action.doInCallableStatement(csToUse);

			Vector restult;
			// 执行新方法
			SpringDBDAO dbdao = new SpringDBDAO();
			// 设置数据源
			dbdao.setConnection(conToUse);
			try {
				// 执行SQL
				restult = dbdao.executeStoredProcedure(callsql, in_params,
						out_params, csToUse,in_out);
				// 获取警告信息
				handleWarnings(cs);
				return restult;
			} catch (Exception e) {
				throw new SQLException(e.getMessage());
			}

			/************************************** 变化点 end ********************************************/

		} catch (SQLException ex) {
			JdbcUtils.closeStatement(cs);
			cs = null;
			DataSourceUtils.releaseConnection(con, getDataSource());
			con = null;
			throw getExceptionTranslator().translate("CallableStatementCallback", callsql, ex);
		} finally {

			JdbcUtils.closeStatement(cs);
			DataSourceUtils.releaseConnection(con, getDataSource());
		}

	}

}
