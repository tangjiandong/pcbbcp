package com.app.jdbc.springframework.jdbc;


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
import javax.sql.DataSource;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.stereotype.Component;



@SuppressWarnings("all")
@Component
public class DBJdbcDaoSupport extends DaoSupport {
	@Resource(name = "jdbcTemplate")
	private DBJdbcTemplate jdbcTemplate;
     /******************* see   JdbcDaoSupport  begin  ******************************/
	public final void setDataSource(DataSource dataSource) {
		if (this.jdbcTemplate == null || dataSource != this.jdbcTemplate.getDataSource()) {
			this.jdbcTemplate = createJdbcTemplate(dataSource);
			initTemplateConfig();
		}
	}

	protected DBJdbcTemplate createJdbcTemplate(DataSource dataSource) {
		return new DBJdbcTemplate(dataSource);
	}	
	public final DataSource getDataSource() {
		return (this.jdbcTemplate != null ? this.jdbcTemplate.getDataSource() : null);
	}
	public final void setJdbcTemplate(DBJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		initTemplateConfig();
	}
	public final DBJdbcTemplate getJdbcTemplate() {
	  return this.jdbcTemplate;
	}
	protected void initTemplateConfig() {
	}


	protected void checkDaoConfig() {
		if (this.jdbcTemplate == null) {
			throw new IllegalArgumentException("'dataSource' or 'jdbcTemplate' is required");
		}
	}


	protected final SQLExceptionTranslator getExceptionTranslator() {
		return getJdbcTemplate().getExceptionTranslator();
	}

	
	public  Connection getConnection() throws CannotGetJdbcConnectionException {
		return DataSourceUtils.getConnection(getDataSource());
	}
	
	public  void releaseConnection(Connection con) {
		DataSourceUtils.releaseConnection(con, getDataSource());
	}
	
	 /******************* see   JdbcDaoSupport  end  ******************************/
	
	

}
