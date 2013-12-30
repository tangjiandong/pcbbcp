/**
 * 文件名: DaoFacadeForBaseImpl.java
 * 作者：caiqf
 * 完成日期：2012-6-13
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.transaction.common.dao.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.app.transaction.common.dao.BaseDaoCommon;
import com.app.transaction.common.dao.facade.DaoFacadeForBase;

/**
 * Class: DaoFacadeForBaseImpl.java Description: 所有dao基类接口门面实现
 * 
 * @author caiqf
 * @date 2012-6-13
 */
@Repository("daoFacadeForBaseImpl")
public class DaoFacadeForBaseImpl implements DaoFacadeForBase {
	@Resource
	private BaseDaoCommon baseDaoCommon;

	public BaseDaoCommon getBaseDaoCommon() {
		return baseDaoCommon;
	}

	public void setBaseDaoCommon(BaseDaoCommon baseDaoCommon) {
		this.baseDaoCommon = baseDaoCommon;
	}
}
