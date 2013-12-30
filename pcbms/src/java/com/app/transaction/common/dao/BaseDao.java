/*
 * 文件名:BaseDao.java
 * 作者：caiqf
 * 完成日期：2012-06-13
 * 维护人员：
 * 维护日期：
 * 维护原因：
 * 当前版本：1.0
 * 前继版本：1.0
 */
package com.app.transaction.common.dao;

import java.util.List;
import java.util.Map;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;

/**
 * Class: BaseDao Description: 所有dao的基类接口
 * 
 * @author caiqf
 * @version 10.0, 2012-06-13
 * @since JDK1.6
 */
@SuppressWarnings("all")
public interface BaseDao {
	/** 根据对象保存对象 */
	public void insert(String id, EntityBase entity) throws Exception;

	/** 根据对象批量保存对象 */
	public void insert(String id, Object obj) throws Exception;

	/** 根据对象删除对象 */
	public int delete(String id, EntityBase entity) throws Exception;

	/** 根据ID删除对象 */
	public int delete(String id, Integer ID) throws Exception;

	/** 根据数组对象删除对象 */
	public int delete(String id, Integer[] IDArray) throws Exception;

	/** 根据对象修改对象 */
	public int update(String id, EntityBase entity) throws Exception;

	/** 根据Map对象修改对象 */
	public int update(String id, Map map) throws Exception;

	/** 根据数组对象修改对象 */
	public int update(String id, Integer[] IDArray) throws Exception;

	/** 根据对象ID来查询对象 */
	public Object getDetailById(String id, Integer ID) throws Exception;

	/** 根据对象属性来查询对象 */
	public Object findByProperty(String id, EntityBase entity) throws Exception;

	/** 根据Map对象来查询对象 */
	public Object findByProperty(String id, Map map) throws Exception;

	/** 根据对象来查询对象列表 */
	public List listByProperty(String id, EntityBase entity) throws Exception;

	/** 根据对象查询数据列表分页 */
	public ReturnData listDataPaging(String id, EntityBase entity)
			throws Exception;
	/** 根据对象查询数据列表分页 (object list) */
	public ReturnData listObjectPaging(String id, EntityBase entity)
			throws Exception;
}
