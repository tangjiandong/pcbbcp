package com.app.jdbc.springframework.jdbc;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.Reader;
import java.math.BigDecimal;
import javax.naming.InitialContext;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import javax.sql.DataSource;
import org.apache.commons.lang.StringUtils;

@SuppressWarnings("all")
public class SpringDBDAO   {
	public static int JDBC_DRIVER_PROVIDER_UNKNOW = 0;
	public static int JDBC_DRIVER_PROVIDER_ORACLE = 1;
	public static int JDBC_DRIVER_PROVIDER_SYBASE = 2;
	public static int JDBC_DRIVER_PROVIDER_INFORMIX = 3;
	public static int JDBC_DRIVER_PROVIDER_POSTGRES = 4;
	public static int JDBC_DRIVER_PROVIDER_MYSQL = 5;
	public static int JDBC_DRIVER_PROVIDER_SQLSERVER = 6;
	public DatabaseMetaData dbmetadata;
	private Connection connection = null;
	
	/**
	 **************************************************************************
	 * 
	 * Connection  常用属性和常用操作  begin
	 * 
	 **************************************************************************
	 */
	
	/**
	 * 获取驱动类名称
	 * @return
	 * @throws Exception
	 */
	private String getDriverName() throws Exception {
		try {
			return this.dbmetadata.getDriverName();
		} catch (Exception ex) {
			throw ex;
		}
	}
	/**
	 * 设置某种数据类型  获取那种数据库类型
	 * @return  int
	 */
	private int getDriverProvider() throws Exception {
       String drvname = getDriverName();
		if ((drvname == null) || (drvname.equals(""))) {
			return JDBC_DRIVER_PROVIDER_UNKNOW;
		}
		if (drvname.indexOf("Oracle") >= 0) {
			return JDBC_DRIVER_PROVIDER_ORACLE;
		}
		if (drvname.indexOf("Post") >= 0) {
			return JDBC_DRIVER_PROVIDER_POSTGRES;
		}
		if (drvname.indexOf("sybase") >= 0) {
			return JDBC_DRIVER_PROVIDER_SYBASE;
		}
		if (drvname.indexOf("MySQL") >= 0) {
			return JDBC_DRIVER_PROVIDER_MYSQL;
		}
		if (drvname.indexOf("MySQL") >= 0) {
			return JDBC_DRIVER_PROVIDER_MYSQL;
		}
		if (drvname.indexOf("Microsoft") >= 0) {
			return JDBC_DRIVER_PROVIDER_SQLSERVER;
		}
		
		
		return JDBC_DRIVER_PROVIDER_UNKNOW;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	
		try {
			dbmetadata=	connection.getMetaData();
		} catch (Exception e) {
			System.out.println("设置连接异常");
		}
	}
	public Connection getConnection() {
		return this.connection;
	}
	
	
	/**
	 * CallableStatement 对象设置参数值
	 * @param pst CallableStatement对象
	 * @param vlist  Vector 对象 存放的参数列表值
	 * @throws Exception
	 */
	private void setSQLValues(CallableStatement pst, Vector vlist)
			throws Exception {
		try {
			if (vlist == null){
				return;
			}
			Object v = null;
			for (int i = 0; i < vlist.size(); ++i) {
				v = vlist.get(i);
				if (v instanceof java.util.Date) {
					java.util.Date d = (java.util.Date) v;
					v = new Timestamp(d.getTime());
				}
				pst.setObject(i + 1, v);
			}

		} catch (Exception ex) {
			
			throw  ex;
		}
	}
	/**
	 * PreparedStatement 对象设置参数值
	 * @param pst PreparedStatement对象
	 * @param vlist  Vector 对象 存放的参数列表值
	 * @throws Exception
	 */
	private void setSQLValues(PreparedStatement pst, Vector vlist)
			throws Exception {
		//清空参数
		pst.clearParameters();
		try {
			if (vlist == null){
				return;
			}
			Object v = null;
			for (int i = 0; i < vlist.size(); ++i) {
				v = vlist.get(i);
				if (v instanceof java.util.Date) {
					java.util.Date d = (java.util.Date) v;
					v = new Timestamp(d.getTime());
				}
				pst.setObject(i + 1, v);
			}

		} catch (Exception ex) {
			throw  ex;
		}
	}


	
	/**
	 * 处理分页 语句  根据 不同的数据库 设置分页SQL语句
	 * @param p_SequenceName
	 * @param p_next_or_curr
	 * @return
	 * @throws DBException
	 */
	private String setRownumControl(String p_sql, int p_iStartRow, int p_iEndRow)
			throws Exception {
		int provider = getDriverProvider();
		switch (provider) {
		case 0:
			return "";
		case 1:
			String temp = p_sql;
			return " select * from  " + " ( "
					+ " select t.*,ROWNUM as ORACLE_ROWNUM from " + " ( "
					+ p_sql + " ) " + " t " + " ) " + "WHERE ORACLE_ROWNUM >"
					+ p_iStartRow + " AND ORACLE_ROWNUM <=" + p_iEndRow;
		case 2:
			return null;
		case 3:
			return null;
		case 4:
		    return null;
		case 5:
			String sql=p_sql;
			 	return " select * from  " + " ( "+sql+" ) "+" f "+" LIMIT "+p_iStartRow+" , "+(p_iEndRow-p_iStartRow)+" ";
			//return sql+" LIMIT "+p_iStartRow+" , "+(p_iEndRow-p_iStartRow)+" ";
			//JDBC_DRIVER_PROVIDER_SQLSERVER
		case 6:  

			return "";
		
		}
		return null;
	}



	/**
	 **************************************************************************
	 * 
	 * Connection  常用属性和常用操作  end
	 * 
	 **************************************************************************
	 */
	
	public int execute(String sql,Vector params,PreparedStatement pst) throws Exception {
		int resut=-1;
		try {
			if (StringUtils.isEmpty(sql)) {
				 throw new Exception("无效SQL");
			}
			if (params != null) {//设置参数
				setSQLValues(pst, params);
			}
			resut=pst.executeUpdate();
			
		} catch (SQLException e) {

		System.err.println(e.getSQLState()+">>"+e.getErrorCode()+">>"+e.getMessage());
		  throw e;	
		}
		return resut;
	}
	
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
	public List query(String sql,Vector params, int startRow, int endRow,PreparedStatement stmtToUse,ResultSet resultSet) throws Exception {
			if(StringUtils.isEmpty(sql)) {
				 throw new Exception("无效SQL");
			}
			DBReader dbr = new DBReader();
	    	String rownum_sql=sql;
			
			if(startRow<endRow){//设置分页SQL语句
				rownum_sql=setRownumControl(sql,startRow,endRow);
			}
			if (params != null) {
				setSQLValues(stmtToUse, params);
			}
			resultSet=stmtToUse.executeQuery();//执行操作	
			dbr.executeQuery(resultSet); //封装 数据
		
		return dbr.getResultList();
	}
	
	
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
	public List query(String sql,Vector params, int startRow, int endRow) throws Exception {
		
			DBReader dbr = new DBReader();
	    	String rownum_sql=sql;
			PreparedStatement pst;
			
			if(startRow<endRow){//设置分页SQL语句
				rownum_sql=setRownumControl(sql,startRow,endRow);
			}
			pst=this.connection.prepareStatement(rownum_sql);
			if (params != null) {
				setSQLValues(pst, params);
			}
			ResultSet resultSet=pst.executeQuery();//执行操作	
			dbr.executeQuery(resultSet); //封装值
			resultSet.close();
			pst.close();
				
		return dbr.getResultList();
	}
	
	
	/**
	 * sql2005 2008 
	 * 
	 *demo  UP_GetRecordByPage ?,?,?,?,?,?
	 *采用PreparedStatement执行存储过程
	 *调用存储过程返回 结果集合
	 * 
	 * @param callsql
	 *            传过来的存储过程带参数  UP_GetRecordByPage ?,?,?,?,?,?
	 * @param params
	 *            传入参数
	 * @return List HashMap格式list结果集
	 */
	public List prepareCall(String callsql,Vector params) throws Exception {
			if(StringUtils.isEmpty(callsql)) {
				 throw new Exception("无效SQL");
			}
			DBReader dbr = new DBReader();
			PreparedStatement pst;
			pst=this.connection.prepareStatement("exec "+callsql);
			if (params != null) {
				setSQLValues(pst, params);
			}
			ResultSet resultSet=pst.executeQuery();//执行操作	
			dbr.executeQuery(resultSet); //封装值
			resultSet.close();
			pst.close();
				
		return dbr.getResultList();
	}
	
	/**
	 * sql2005 2008 
	 *demo  call newjobs(?,?.....)
	 *采用CallableStatement执行存储过程
	 *调用存储过程返回 结果集合
	 * 
	 * @param callsql
	 *            传过来的存储过程带参数  UP_GetRecordByPage ?,?,?,?,?,?
	 * @param params
	 *            传入参数
	 * @return List HashMap格式list结果集
	 */
	public List callList(String callsql,Vector params) throws Exception {
			if(StringUtils.isEmpty(callsql)) {
				 throw new Exception("无效SQL");
			}
			DBReader dbr = new DBReader();
			CallableStatement pst;
			pst=this.connection.prepareCall("{call "+callsql+"}");
			if (params != null) {
				setSQLValues(pst, params);
			}
			ResultSet resultSet=pst.executeQuery();//执行操作	
			dbr.executeQuery(resultSet); //封装值
			resultSet.close();
			pst.close();
				
		return dbr.getResultList();
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
	public Vector executeStoredProcedure(String callsql,Vector in_params,Vector out_params,CallableStatement pst,int in_out) throws Exception {
		
		  if(StringUtils.isEmpty(callsql)) {
			 throw new Exception("无效SQL");
		  }
			//DBReader dbr = new DBReader();
			//CallableStatement pst;
			//pst=this.connection.prepareCall("{call "+callsql+"}");
			int index=0;
			//输入参数
			if (in_params != null) {
				setSQLValues(pst, in_params);
				index=in_params.size();
			}
			//获取参数个数
			if (out_params != null) {
				setStoredProcedureOutParams(pst,out_params,index-in_out);
			}
			//执行
			pst.execute();	
		   //获取输出参数值
			if (out_params != null) {
		    getStoredProcedureOutParamsValues(pst,out_params,index-in_out);
		   }
			
		return out_params;
	}
	/**
	 * 
	 * 设置输出参数 
	 * @param CallableStatement
	 *             
	 * @param Vector
	 *            输出参数
	 * @return void
	 */
	private void setStoredProcedureOutParams(CallableStatement pst,Vector out_params,int index)throws Exception {
		try {
			if (out_params == null){
				return;
			}
			for (int i = 1; i <= out_params.size(); i++) {	
				
				pst.registerOutParameter(i + index, java.sql.Types.VARCHAR);
			}

		} catch (Exception ex) {
			throw  ex;
		}
	}
	/**
	 * 
	 * 获取存储过程输出参数值
	 * @param CallableStatement
	 *             
	 * @param Vector
	 *            输出参数
	 * @return void
	 */
	private void getStoredProcedureOutParamsValues(CallableStatement pst,Vector out_params,int index)throws Exception {
		try {
			if (out_params == null){
				return;
			}
			int size=out_params.size();
			out_params.clear();
			for (int i = 1; i <=size;i++) {			
				//设置输出参数值
				out_params.add(i-1, pst.getObject(i + index));			
			}

		} catch (Exception ex) {
		
			throw  ex;
		}
	}
	
	
	
	/**sql2005 2008 
	 * 根据传入sql语句,传入参数返回HashMap格式的list结果集 sql语句必须为 as格式如 select id as id, name as
	 * name from demo
	 * 
	 * @param sql
	 *            传过来的sql语句
	 * @param params
	 *            传入参数
	 * @return List HashMap格式list结果集
	 */
	public List query_sql(String sql,Vector params, int startRow, int endRow,String oderbystr) throws Exception {
		
			DBReader dbr = new DBReader();
	    	StringBuffer rownum_sql=new StringBuffer("");
			PreparedStatement pst;
			
			
			if(startRow<endRow){//设置分页SQL语句
				//sql2005 2008
////			 select top 10 * from (
//				 select row_number() over(order by title desc) rownum,*
//				 from  (select * from  pic_list pic  ) 
//				 t_sql ) 
//				 t_pager
//			     where t_pager.rownum>10
				int size=endRow-startRow;
				rownum_sql.append(" select top "+size+" * from  (");
				rownum_sql.append(" select row_number() over( "+oderbystr +" ) rownum,* ");
				rownum_sql.append(" from  ("+sql+") ");
				rownum_sql.append(" t_sql ) ");
				rownum_sql.append(" t_pager ");
				rownum_sql.append("  where t_pager.rownum>"+startRow);
			}
			pst=this.connection.prepareStatement(rownum_sql.toString());
			if (params != null) {
				setSQLValues(pst, params);
			}
			ResultSet resultSet=pst.executeQuery();//执行操作	
			dbr.executeQuery(resultSet); //封装值
			resultSet.close();
			pst.close();
				
		return dbr.getResultList();
	}
	
	
	
	/**
	 * 读取数据辅助类   内部类
	 */
	public class DBReader {
		
		protected ResultSet resultset;
		protected ResultSetMetaData metadata;
		protected String[] fields = new String[0]; //列名名称数组
		private List resultList =null; // 其中装载 Map集合 

		public void executeQuery(ResultSet resultSet) throws Exception {
				this.resultset =resultSet;
				this.metadata = this.resultset.getMetaData();
				getDataFromResultSetMap();
		}
		/** 
		 * resultList 设置值  其中装载 Map的数组   返回查询结果
		 * @throws Exception
		 */
		private void getDataFromResultSetMap()
				throws Exception {
			int numberOfColumns = this.metadata.getColumnCount();
			this.fields = new String[numberOfColumns];
	        //设置字段
			for (int column = 0; column < numberOfColumns; ++column) {
				this.fields[column] = this.metadata.getColumnName(column + 1);
			}
	       //设置结果值 
			this.resultList = new ArrayList();
			while (this.resultset.next()) {
				
				Map newRow = new HashMap();
				for (int i = 1; i <= numberOfColumns; ++i) {
					String typeName = this.metadata.getColumnTypeName(i);
					String key = "";
					String value = "";
					key = fields[i-1].toLowerCase(); // 将字段名称设置为统一为小写  并且设置为Map的key的值
					if (typeName.equals("NUMBER")) { //数字类型
						try {
							BigDecimal bd = this.resultset.getBigDecimal(i);
							if(bd!=null){
							  value = bd.toString();
							}
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("数字类型转换异常！");
							continue;
						}
					}else if(typeName.equals("CLOB")){//大文本类型
						try {
							java.sql.Clob clob = this.resultset.getClob(i);
							StringBuilder content=new StringBuilder("");
							if (clob != null) {
								Reader is = clob.getCharacterStream();
								BufferedReader br = new BufferedReader(is);				
								String s = br.readLine();
								while (s != null) {
									if(s!=null){
								//  String temp=new String(s.getBytes("ISO-8859-1"), "utf-8");
								    content.append(s);
									s = br.readLine();
									}
								}
								br.close();
								is.close();
							}
							value = content.toString();
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("大文本类型转换异常！");
							continue;
						}	 
					} else {
						value = this.resultset.getString(i);
						
						if(value==null ||value==""){
							value="";
						}
						// 输出时间去掉最后"."符号
						if (value.indexOf("-") != -1 && value.indexOf(" ") != -1
								&& value.indexOf(":") != -1
								&& value.indexOf(".") != -1) {
							value = value.substring(0, value.lastIndexOf("."));	
						}
					}
					//填充数据
					newRow.put(key, value.trim());
				}
				this.resultList.add(newRow);
			}
		}
		
		public List getResultList() {
			return resultList;
		}
		
	}
	
}
