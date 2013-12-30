/**
 * @Filename: PwdUtil.java
 * @Author：caiqf
 * @Date：2013-7-2
 */
package com.app.utils.util;

import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.app.utils.constant.Constant;

/**
 * @Class: PwdUtil.java
 * @Description: 密码工具类
 * @Author：caiqf
 * @Date：2013-7-2
 */
public class PwdUtil {
	private static final Log log = LogFactory.getLog(PwdUtil.class);

	/**
	 * @Author：caiqf
	 * @Description: 判断密码级别
	 * @Date：2013-7-2 上午9:33:05
	 * @Return：String
	 */
	public String pwlevel(String pwd) {
		String pwlevel = "1";
		try {
			Pattern pattern = Pattern.compile(Constant.C09);
			boolean flag = pattern.matcher(pwd).matches();
			if (!flag) { // 不是纯数字
				if (pwd.length() <= 6) {
					pwlevel = "1"; // 弱
				} else if (pwd.length() >= 7 && pwd.length() <= 9) {
					pwlevel = "2"; // 中等
				} else if (pwd.length() >= 10 && pwd.length() <= 16) {
					pwlevel = "3"; // 强
				}
			} else {
				if (pwd.length() <= 8) {
					pwlevel = "1"; // 弱
				} else if (pwd.length() >= 9 && pwd.length() <= 16) {
					pwlevel = "2"; // 中等
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return pwlevel;
	}
}
