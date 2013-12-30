package com.app.utils.test;



import java.util.Map;

import com.app.module.news.dto.TAppNewscenter;
import com.app.module.news.dto.TAppWebsiteInfo;








public class MapperXmlTest {

	/**
	 * @param args
	 *
	 * @author 汤建东
	 * @date 2013-1-7 下午4:47:08
	 * 
	 */
	public static void main(String[] args) {
		
		TAppWebsiteInfo umlRegion=new TAppWebsiteInfo();
		
	Map objMap=VoHelpTest.setObjectModelForMap(umlRegion);
	
	String remarks="新闻采集规则";
   //	remarks.length()
	String tableName="t_app_website_info";
	String entityName="TAppWebsiteInfo";
	 //添加
	System.out.println(insertSql(entityName, tableName,  objMap,"添加"+remarks));
	 //修改
    System.out.println(updateSql(entityName, tableName,  objMap,"修改"+remarks));
   //	 //查询
   System.out.println(selectSql(entityName, tableName,  objMap,"查询"+remarks));
	 //查询
	System.out.println(deleteSql(entityName, tableName,  objMap,"删除"+remarks));
	 
	}
	
	/**
	 * 添加SQL映射文件
	 * @param entityName
	 * @param tableName
	 * @param objMap
	 * @param remarks
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-1-7 下午5:00:17
	 *
	 */
	public static  String insertSql(String entityName,String tableName, Map objMap,String remarks){
		
		objMap.remove("id");
		objMap.remove("serialVersionUID");
//		<!-- 新增银行信息 -->
//		<insert id="insertTHtUlposBankinfoByModel" parameterType="THtUlposBankinfo" useGeneratedKeys="true" keyProperty="id">
//			insert into t_ht_ulpos_bankinfo
//			(bankid,bankname,banklogo,credate)
//			values
//			(#{bankid},#{bankname},#{banklogo},#{credate})
//		</insert>
		
		StringBuffer sql = new StringBuffer("");
		sql.append("<!-- "+remarks+"-->\n");
		sql.append("<insert id=\"insert"+entityName+"ByModel\" parameterType=\""+entityName+"\" useGeneratedKeys=\"true\" keyProperty=\"id\">\n");
		//添加SQL
		sql.append(VoHelpTest.setInsertOrUpdateMyBatisSql(tableName, objMap, "insert")+"\n");
		sql.append("</insert>\n");	
		
		return sql.toString();
	}
	
	/**
	 *修改SQL映射文件
	 * @param entityName
	 * @param tableName
	 * @param objMap
	 * @param remarks
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-1-7 下午5:00:17
	 *
	 */
	public static String updateSql(String entityName,String tableName, Map objMap,String remarks){
		
		objMap.remove("id");
		objMap.remove("serialVersionUID");
//		<!-- 修改银行信息 -->
//		<update id="updateTHtUlposBankinfoByModel" parameterType="THtUlposBankinfo">
//			update t_ht_ulpos_bankinfo
//			<trim prefix="set" suffixOverrides=",">
//				<if test="bankid != null">
//					bankid = #{bankid}, 
//				</if>
//				<if test="bankname != null">
//					bankname = #{bankname}, 
//				</if>
//				<if test="banklogo != null">
//					banklogo = #{banklogo}, 
//				</if>
//				<if test="credate != null">
//					credate = #{credate} 
//				</if>
//			</trim>
//			where 1 = 1
//			<if test="id != null">
//				and id = #{id} 
//			</if>
//		</update>
		
		StringBuffer sql = new StringBuffer("");
		sql.append("<!-- "+remarks+"-->\n");
		sql.append("<update id=\"update"+entityName+"ByModel\" parameterType=\""+entityName+"\" > \n");
		
		sql.append(" update   "+tableName+"\n");
		sql.append("  <trim prefix=\"set\" suffixOverrides=\",\">  \n");
		//添加SQL
		sql.append("   "+VoHelpTest.setInsertOrUpdateMyBatisSql_APP(tableName, objMap)+"\n");
		sql.append("  </trim>  \n");
		
		sql.append(" where  1=1  \n");
		sql.append("  <if test=\"id != null\">  \n");
		sql.append("   and id = #{id}   \n");
		sql.append("  </if> \n");
		
		sql.append("</update>\n");	
		
		return sql.toString();
	}
	
	/**
	 * 删除操作
	 * @param entityName
	 * @param tableName
	 * @param objMap
	 * @param remarks
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-1-7 下午5:20:27
	 *
	 */
	public static String deleteSql(String entityName,String tableName, Map objMap,String remarks){
		
		objMap.remove("id");
		objMap.remove("serialVersionUID");
//		<!-- 删除银行信息 -->
//		<delete id="deleteTHtUlposBankinfoByModel" parameterType="THtUlposBankinfo">
//			delete from t_ht_ulpos_bankinfo
//			where 1 = 1
//			<if test="id != null">
//				and id = #{id} 
//			</if>
//		</delete>
		
		StringBuffer sql = new StringBuffer("");
		sql.append("<!-- "+remarks+"-->\n");
		sql.append("<delete id=\"delete"+entityName+"ByModel\" parameterType=\""+entityName+"\">\n");
		//添加SQL
		
		sql.append(" delete  from  "+tableName+"  where  1=1\n");
		
		sql.append("  <if test=\"id != null\">  \n");
		sql.append("   and id = #{id}   \n");
		sql.append("  </if> \n");
		
		sql.append("</delete>\n");	
		
		return sql.toString();
	}
	/**
	 *查询SQL映射文件
	 * @param entityName
	 * @param tableName
	 * @param objMap
	 * @param remarks
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-1-7 下午5:00:17
	 *
	 */
	public static String selectSql(String entityName,String tableName, Map objMap,String remarks){
		
		//objMap.remove("id");
		objMap.remove("serialVersionUID");
//		<!-- 查询银行信息 -->
//		<select id="selectTHtUlposBankinfoByModel" parameterType="THtUlposBankinfo"
//				resultType="THtUlposBankinfo">
//				select * from t_ht_ulpos_bankinfo where 1 = 1
//				<if test="id != null">
//					and id = #{id} 
//				</if>
//				<if test="bankid != null">
//					and bankid = #{bankid} 
//				</if>
//			</select>
		
		StringBuffer sql = new StringBuffer("");
		sql.append("<!-- "+remarks+"-->\n");
		sql.append("<select id=\"select"+entityName+"ByModel\" parameterType=\""+entityName+"\"  resultType=\""+entityName+"\"> \n");
		
		sql.append(" select * from    "+tableName+"   where 1=1 \n");
	
		//添加SQL
		sql.append("   "+VoHelpTest.setInsertOrUpdateMyBatisSql_Select(tableName, objMap)+"\n");
	
		
		sql.append("</select>\n");	
		
		return sql.toString();
	}
	

}
