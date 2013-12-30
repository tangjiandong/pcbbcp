/**
 * 文件名: BaseServiceImpl.java
 * 作者：caiqf
 * 完成日期：2012-6-13
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.transaction.common.impl.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.dao.facade.DaoFacadeForBase;
import com.app.transaction.common.service.BaseService;

/**
 * Class: BaseServiceImpl.java Description:
 * 
 * @author caiqf
 * @date 2012-6-13
 */
@SuppressWarnings("all")
public class BaseServiceImpl implements BaseService {
	protected transient final Log log = LogFactory.getLog(getClass());

	@Resource
	protected DaoFacadeForBase daoFacadeForBase;

	/**
	 * 根据对象保存对象
	 */
	@Override
	public void insert(String id, EntityBase entity) throws Exception {
		try {
			this.daoFacadeForBase.getBaseDaoCommon().insert(id, entity);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
	}

	/**
	 * 根据对象批量保存对象
	 */
	@Override
	public void insert(String id, Object obj) throws Exception {
		try {
			this.daoFacadeForBase.getBaseDaoCommon().insert(id, obj);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
	}

	/**
	 * 根据对象删除对象
	 */
	@Override
	public int delete(String id, EntityBase entity) throws Exception {
		int r = 0;
		try {
			r = this.daoFacadeForBase.getBaseDaoCommon().delete(id, entity);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return r;
	}

	/**
	 * 根据对象删除对象
	 */
	@Override
	public int delete(String id, Integer ID) throws Exception {
		int r = 0;
		try {
			r = this.daoFacadeForBase.getBaseDaoCommon().delete(id, ID);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return r;
	}

	/**
	 * 根据数组对象删除对象
	 */
	@Override
	public int delete(String id, Integer[] IDArray) throws Exception {
		int r = 0;
		try {
			r = this.daoFacadeForBase.getBaseDaoCommon().delete(id, IDArray);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return r;
	}

	/**
	 * 根据对象修改对象
	 */
	@Override
	public int update(String id, EntityBase entity) throws Exception {
		int r = 0;
		try {
			r = this.daoFacadeForBase.getBaseDaoCommon().update(id, entity);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return r;
	}

	/**
	 * 根据Map对象修改对象
	 */
	@Override
	public int update(String id, Map map) throws Exception {
		int r = 0;
		try {
			r = this.daoFacadeForBase.getBaseDaoCommon().update(id, map);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return r;
	}

	/**
	 * 根据数组对象修改对象
	 */
	@Override
	public int update(String id, Integer[] IDArray) throws Exception {
		int r = 0;
		try {
			r = this.daoFacadeForBase.getBaseDaoCommon().update(id, IDArray);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return r;
	}

	/**
	 * 根据对象ID来查询对象
	 */
	@Override
	public Object getDetailById(String id, Integer ID) throws Exception {
		Object o = null;
		try {
			o = this.daoFacadeForBase.getBaseDaoCommon().getDetailById(id, ID);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return o;
	}

	/**
	 * 根据对象属性来查询对象
	 */
	@Override
	public Object findByProperty(String id, EntityBase entity) throws Exception {
		Object o = null;
		try {
			o = this.daoFacadeForBase.getBaseDaoCommon().findByProperty(id,
					entity);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return o;
	}

	/**
	 * 根据Map对象来查询对象
	 */
	@Override
	public Object findByProperty(String id, Map map) throws Exception {
		Object o = null;
		try {
			o = this.daoFacadeForBase.getBaseDaoCommon()
					.findByProperty(id, map);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return o;
	}

	/**
	 * 根据对象来查询对象列表
	 */
	@Override
	public List listByProperty(String id, EntityBase entity) throws Exception {
		List list = null;
		try {
			list = this.daoFacadeForBase.getBaseDaoCommon().listByProperty(id,
					entity);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return list;
	}

	/**
	 * 根据对象查询数据列表分页
	 */
	@Override
	public ReturnData listDataPaging(String id, EntityBase entity)
			throws Exception {
		ReturnData r = null;
		try {
			r = this.daoFacadeForBase.getBaseDaoCommon().listDataPaging(id,
					entity);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		return r;
	}
}
