/*
 * 文件名:BaseDaoImpl.java
 * 作者：caiqf
 * 完成日期：2012-06-13
 * 维护人员：
 * 维护日期：
 * 维护原因：
 * 当前版本：1.0
 */
package com.app.transaction.common.impl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.dao.BaseDao;

/**
 * Class: BaseDaoImpl Description: 所有dao的基类的实现类，常用的增，删，改，查，数据分页
 * 
 * @author caiqf
 * @version 10.0, 2012-06-13
 * @since JDK1.6
 */
@SuppressWarnings("all")
public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao {
	/**
	 * 根据对象保存对象
	 */
	@Override
	public void insert(String id, EntityBase entity) throws Exception {
		this.getSqlSession().insert(id, entity);
	}

	/**
	 * 根据对象批量保存对象
	 */
	@Override
	public void insert(String id, Object obj) throws Exception {
		this.getSqlSession().insert(id, obj);
	}

	/**
	 * 根据对象删除对象
	 */
	@Override
	public int delete(String id, EntityBase entity) throws Exception {
		return this.getSqlSession().delete(id, entity);
	}

	/**
	 * 根据ID删除对象
	 */
	@Override
	public int delete(String id, Integer ID) throws Exception {
		return this.getSqlSession().delete(id, ID);
	}

	/**
	 * 根据数组对象删除对象
	 */
	@Override
	public int delete(String id, Integer[] IDArray) throws Exception {
		return this.getSqlSession().delete(id, IDArray);
	}

	/**
	 * 根据对象修改对象
	 */
	@Override
	public int update(String id, EntityBase entity) throws Exception {
		return this.getSqlSession().update(id, entity);
	}

	/**
	 * 根据Map对象修改对象
	 */
	@Override
	public int update(String id, Map map) throws Exception {
		return this.getSqlSession().update(id, map);
	}

	/**
	 * 根据数组对象修改对象
	 */
	@Override
	public int update(String id, Integer[] IDArray) throws Exception {
		return this.getSqlSession().update(id, IDArray);
	}

	/**
	 * 根据对象ID来查询对象
	 */
	@Override
	public Object getDetailById(String id, Integer ID) throws Exception {
		return this.getSqlSession().selectOne(id, ID);
	}

	/**
	 * 根据对象属性来查询对象
	 */
	@Override
	public Object findByProperty(String id, EntityBase entity) throws Exception {
		return this.getSqlSession().selectOne(id, entity);
	}

	/**
	 * 根据Map对象来查询对象
	 */
	@Override
	public Object findByProperty(String id, Map map) throws Exception {
		return this.getSqlSession().selectOne(id, map);
	}

	/**
	 * 根据对象来查询对象列表
	 */
	@Override
	public List listByProperty(String id, EntityBase entity) throws Exception {
		return this.getSqlSession().selectList(id, entity);
	}

	/**
	 * 根据对象查询数据列表分页
	 */
	@Override
	public ReturnData listDataPaging(String id, EntityBase entity)
			throws Exception {
		try {
			List<EntityBase> listData = new ArrayList<EntityBase>();
			int pageCount = 0;
			Integer count = 0;
			ReturnData rd = new ReturnData();
			listData = this.getSqlSession().selectList(id, entity);
			Object object = this.getSqlSession().selectOne(id + "_count",
					entity);
			count = (Integer) (object != null ? object : 0);
			if (count != null && count != 0) {
				pageCount = count % entity.getPageSize() == 0 ? count
						/ entity.getPageSize() : count / entity.getPageSize()
						+ 1;
			}
			rd.setRecordCount(count == null ? 0 : count);
			rd.setResultlist(listData);
			rd.setPageCount(pageCount);
			rd.setPageNumber(entity.getPageNumber());
			return rd;
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}
	/** 根据对象查询数据列表分页 (object list) */
	public ReturnData listObjectPaging(String id, EntityBase entity)
			throws Exception {
		try {
			List<Object> objectList = new ArrayList<Object>();
			int pageCount = 0;
			Integer count = 0;
			ReturnData rd = new ReturnData();
			objectList = this.getSqlSession().selectList(id, entity);
			Object object = this.getSqlSession().selectOne(id + "_count",
					entity);
			count = (Integer) (object != null ? object : 0);
			if (count != null && count != 0) {
				pageCount = count % entity.getPageSize() == 0 ? count
						/ entity.getPageSize() : count / entity.getPageSize()
						+ 1;
			}
			rd.setRecordCount(count == null ? 0 : count);

			rd.setObjectList(objectList);
			rd.setPageCount(pageCount);
			rd.setPageNumber(entity.getPageNumber());
			return rd;
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}
}
