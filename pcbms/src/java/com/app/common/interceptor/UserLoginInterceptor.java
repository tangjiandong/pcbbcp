/**
 * 文件名: UserLoginInterceptor.java
 * 作者：caiqf
 * 完成日期：2012-6-26
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.common.interceptor;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.app.transaction.common.action.BaseAction;
import com.app.utils.constant.Constant;
import com.app.utils.util.LoginUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Class: UserLoginInterceptor.java Description: 用户登录拦截器
 * 
 * @author caiqf
 * @date 2012-6-26
 */
@SuppressWarnings("all")
public final class UserLoginInterceptor implements Interceptor {
	private static final long serialVersionUID = -5780358249767918441L;

	public UserLoginInterceptor() {

	}


	public void destroy() {

	}


	public void init() {

	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-6-26 上午11:17:06
	 * @describe 用户登录拦截方法
	 * @return String
	 */
	
	public String intercept(ActionInvocation invocation) throws Exception {
		// 拦截非登录和注册外的所有请求
		HttpServletRequest request = ServletActionContext.getRequest(); // request
		HttpServletResponse response = ServletActionContext.getResponse(); // response
		BaseAction action = (BaseAction) invocation.getAction(); // 父类action
		if (null == LoginUtil.getLoginInfo(request)) { // 未登录
			// 清除登录用户会话信息
			LoginUtil.deleteLoginInfo(request, response);

			// 判断是页面跳转登录还是异步登录
			String header = request.getHeader("X-Requested-With");
			if (header != null && header.equals("XMLHttpRequest")) {
				PrintWriter out = response.getWriter();
				out.write("3333"); // Ajax请求重新登录标识
				out.flush();
				out.close();
				return null;
			} else {
				return this.gotoLoginPage(action, response, request,
						"登录已经过期，请重新登录");
			}
		} else { // 已登录
			return invocation.invoke();
		}
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-6-26 上午11:17:06
	 * @describe 重新登录后跳转到之前页面
	 * @return String
	 */
	public String gotoLoginPage(BaseAction action,
			HttpServletResponse response, HttpServletRequest request,
			String errorMsg) {
		String reqURL = request.getRequestURI();
		Enumeration enu = request.getParameterNames();
		StringBuffer params = (new StringBuffer(400)).append(reqURL);
		if (enu.hasMoreElements())
			params.append("?");

		String param;
		for (; enu.hasMoreElements(); params.append(param).append("=").append(
				request.getParameter(param)).append("&"))
			param = enu.nextElement().toString();

		// 返回路径url
		String url = "";
		if ("&".equals(params.substring(params.length() - 1))) {
			url = params.substring(0, params.length() - 1);
		} else {
			url = params.toString();
		}
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.setValue("fromurl", url);
		return Constant.LOGIN_OF_WEB;
	}
}
