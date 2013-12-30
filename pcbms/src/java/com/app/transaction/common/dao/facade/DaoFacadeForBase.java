/**
 * 文件名: DaoFacadeForBase.java
 * 作者：caiqf
 * 完成日期：2012-6-13
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.transaction.common.dao.facade;

import com.app.transaction.common.dao.BaseDaoCommon;

/**
 * Class: DaoFacadeForBase.java Description: 所有dao基类接口门面
 * 
 * @author caiqf
 * @date 2012-6-13
 */
public interface DaoFacadeForBase {
	public BaseDaoCommon getBaseDaoCommon();

	public void setBaseDaoCommon(BaseDaoCommon baseDaoCommon);
}
