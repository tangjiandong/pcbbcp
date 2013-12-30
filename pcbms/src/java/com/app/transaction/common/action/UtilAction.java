/**
 * 文件名:UtilAction.java
 * 作者：caiqf
 * 完成日期：2012-6-16
 * 维护人员：
 * 维护日期：
 * 维护原因：
 * 当前版本：1.0
 */
package com.app.transaction.common.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class: UtilAction.java Description: 公用的工具类Action
 * 
 * @author caiqf
 * @version 1.0, 2012-12-14
 * @since JDK1.6
 */
public class UtilAction extends BaseAction {
	private static final long serialVersionUID = -8734161508548767305L;

	/**
	 * @author caiqifan
	 * @date 2012-3-14 上午10:23:27
	 * @describe 获取服务器当前时间
	 * @return void
	 * @exception
	 * @version 1.0
	 */
	public void getDate() {
		PrintWriter out = this.getWriter();
		out.print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date()));
		if (out != null) {
			out.flush();
			out.close();
		}
	}
}
