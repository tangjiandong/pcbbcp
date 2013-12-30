/**
 * 文件名: LoginAction.java
 * 作者：caiqf
 * 完成日期：2012-12-14
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.transaction.user.action;

import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;

import com.app.module.user.dto.TTgUserinfo;
import com.app.transaction.common.action.BaseAction;
import com.app.transaction.user.service.UserService;
import com.app.utils.constant.MD5;
import com.app.utils.util.LoginUtil;

/**
 * Class: LoginAction.java Description: 用户登录Action
 * 
 * @author caiqf
 * @date 2012-12-14
 */
public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 4411452158844797178L;

	@Resource
	private UserService userService;

	private String username; // 用户名
	private String password; // 密码

	/**
	 * 
	 * @author caiqf
	 * @date 2012-12-14 下午03:51:45
	 * @describe 进入登录页面
	 * @return String
	 */
	public String index() {
		return "index";
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-6-19 下午04:10:53
	 * @describe 用户登录提交
	 * @return String
	 */
	public void loginSub() {
		PrintWriter out = this.getWriter();
		String flag = "";
		try {
			/** 校验登录信息 */
			if (null == this.username.trim() || "".equals(this.username.trim())) {
				flag = "1"; // 用户名为空
				return;
			}

			// 根据登录名查询用户登录信息
			TTgUserinfo user = new TTgUserinfo();
			user.setUsername(this.username); // 用户名
			Object u = this.userService.findTTgUserinfo(user);
			if (null == u) {
				flag = "2"; // 用户不存在
				return;
			}
			user = (TTgUserinfo) u;
			if ("0".equals(user.getIsvalid())) {
				flag = "3"; // 用户无效
				return;
			}
			if (null == this.password.trim() || "".equals(this.password.trim())) {
				flag = "4"; // 密码为空
				return;
			}
			if (!user.getPassword().equals(
					MD5.getInstance().getMD5(this.password))) {
				flag = "5"; // 密码错误
				return;
			}

			/** 保存登录用户会话 */
			LoginUtil.deleteLoginInfo(this.getRequest(), this.getResponse());
			LoginUtil.setLoginInfo(this.getRequest(), this.getResponse(),
					user.getUserid(), user.getUsername(), new Date().getTime());

			flag = "0000"; // 成功
		} catch (Exception e) {
			flag = "1111"; // 失败
			log.error(e.getMessage(), e);
		} finally {
			out.print(flag);
			out.flush();
			out.close();
		}
	}

	

	/**
	 * 
	 * @author 
	 * @date 2012-6-19 下午04:10:53
	 * @describe 用户登出
	 * @return String
	 */
	public String voteexit() {
		try {
			/** 删除登录用户会话信息 */
			LoginUtil.deleteLoginInfo(this.getRequest(), this.getResponse());
			this.sendRedirect("voteIndex.do");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "error";
		}
		
		return null;
		//return "index";
	}
	/**
	 * 
	 * @author 
	 * @date 2012-6-19 下午04:10:53
	 * @describe 用户登出
	 * @return String
	 */
	public String exit() {
		try {
			/** 删除登录用户会话信息 */
			LoginUtil.deleteLoginInfo(this.getRequest(), this.getResponse());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "error";
		}
		return "index";
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-7-2 上午11:03:43
	 * @describe 获取登录用户名
	 * @return void
	 */
	public void getUserName() {
		PrintWriter out = this.getWriter();
		String flag = "";
		if (null != this.getLoginUserName()
				&& !"".equals(this.getLoginUserName())) {
			flag = this.getLoginUserName();
		}
		out.print(flag);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 
	 * @author 
	 * @date 2012-12-15 上午11:06:17
	 * @describe 用户登录弹出框页面
	 * @return String
	 */
	public String loginAlert() {
		return "alert";
	}

	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
