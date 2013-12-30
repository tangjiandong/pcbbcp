/**
 * 文件名: LoginUtil.java
 * 作者：caiqf
 * 完成日期：2013-1-6
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.utils.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.app.utils.constant.Constant;
import com.app.utils.constant.MD5;

/**
 * Class: LoginUtil.java Description: 用户登录会话工具类
 * 
 * @author caiqf
 * @date 2013-1-6
 */
public class QdLoginUtil {
	private static final Logger log = Logger.getLogger(QdLoginUtil.class);

	private final static String KEY_FOR_USER = "!$%^@abcd#$#@ttgmsQdUser";

	/**
	 * 
	 * @author caiqf
	 * @date 2013-1-6 上午11:05:57
	 * @describe 删除登录用户信息
	 * @return String
	 */
	public static void deleteLoginInfo(HttpServletRequest request,
			HttpServletResponse response) {
		// Cookie
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (int i = 0; i < cookies.length; i++) {
				if (Constant.LOGIN_COOKIE_qdNAME.equals(cookies[i].getName())) {
					Cookie cookie = new Cookie(cookies[i].getName(), null);
					cookie.setMaxAge(0); // 设置过期时长
					response.addCookie(cookie); // 设置Cookie
					break;
				}
			}
		}
		// Session
		request.getSession().removeAttribute(Constant.LOGIN_SESSION_qdNAME);
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2013-1-6 上午11:04:45
	 * @describe 设置登录用户信息
	 * @return String
	 */
	public static void setLoginInfo(HttpServletRequest request,
			HttpServletResponse response, Integer userid, String username,Integer salesid,
			long longTime) {
		String loginstr = createKeyForUser(userid, System.currentTimeMillis())
				+ "++" + userid + "++" + username + "++" + salesid + "++" + longTime;
		try {
			// Cookie
			Cookie cookie = new Cookie(Constant.LOGIN_COOKIE_qdNAME,
					URLEncoder.encode(loginstr, "UTF-8"));
			cookie.setMaxAge(30 * 24 * 60 * 60); // 设置过期时长
			response.setCharacterEncoding("UTF-8"); // 中文用户需要转码
			response.addCookie(cookie); // 设置Cookie
			// Session
			request.getSession().removeAttribute(Constant.LOGIN_SESSION_qdNAME);
			request.getSession().setAttribute(Constant.LOGIN_SESSION_qdNAME,
					loginstr);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2013-1-6 上午11:05:57
	 * @describe 获取登录用户信息
	 * @return String
	 */
	public static String getLoginInfo(HttpServletRequest request) {
		String loginstr = null;
		try {
			// Cookie
			Cookie[] cookies = request.getCookies();
			if (null != cookies) {
				for (int i = 0; i < cookies.length; i++) {
					if (Constant.LOGIN_COOKIE_qdNAME.equals(cookies[i].getName())) {
						loginstr = URLDecoder.decode(cookies[i].getValue(),
								"UTF-8");
					}
				}
			}
			// Session
			if (null == loginstr || "".equals(loginstr)) {
				loginstr = (String) request.getSession().getAttribute(
						Constant.LOGIN_SESSION_qdNAME);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return loginstr;
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2013-1-6 上午11:05:57
	 * @describe 获取登录渠道用户编号
	 * @return String
	 */
	public static Integer getLoginUserId(HttpServletRequest request) {
		Integer userid = null;
		String loginstr = getLoginInfo(request);
		if (null != loginstr && !"".equals(loginstr)) {
			String[] logininfo = loginstr.split("\\++");
			if (logininfo.length >= 4) {
				return new Integer(logininfo[1]);
			}
		}
		return userid;
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2013-1-6 上午11:05:57
	 * @describe 获取登录渠道用户名称
	 * @return String
	 */
	public static String getLoginUserName(HttpServletRequest request) {
		String username = null;
		String loginstr = getLoginInfo(request);
		if (null != loginstr && !"".equals(loginstr)) {
			String[] logininfo = loginstr.split("\\++");
			if (logininfo.length >= 4) {
				return logininfo[2];
			}
		}
		return username;
	}

	/**
	 * 
	 * @author bill
	 * @date 2013-8-7
	 * @describe 获取登录渠道编号
	 * @return Integer
	 */
	public static Integer getLoginSalesid(HttpServletRequest request) {
		Integer salesid = null;
		String loginstr = getLoginInfo(request);
		if (null != loginstr && !"".equals(loginstr)) {
			String[] logininfo = loginstr.split("\\++");
			if (logininfo.length >= 4) {
				return new Integer(logininfo[3]);
			}
		}
		return salesid;
	}

	
	/**
	 * 
	 * @author caiqf
	 * @date 2013-1-6 上午11:12:10
	 * @describe 创建登录用户唯一KEY
	 * @return String
	 */
	public static String createKeyForUser(Integer userid, Long time) {
		String keyDate = DateUtil.simpleDateFormat1.format(new Timestamp(time));
		int key = (userid + "" + keyDate + "" + KEY_FOR_USER).hashCode();
		return MD5.getInstance().getMD5(key + "");
	}
}
