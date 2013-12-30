package com.app.utils.util;

import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.app.utils.tool.ResourceReader;

/**
 * @Class: SmsUtil.java
 * @Description: 发送短信工具类
 * @Author：caiqf
 * @Date：2013-6-24
 */
public class SmsUtil {
	protected static final Log log = LogFactory.getLog(SmsUtil.class);

	/**
	 * @Author：caiqf
	 * @Description: 发送短信
	 * @Date：2013-6-24 下午5:56:41
	 * @Return：String
	 */
	public static String sendSMS(String mobile, String content) {
		String flag = null;
		try {
			if (null != mobile && !"".equals(mobile) && null != content
					&& !"".equals(content)) {
				TreeMap<String, String> paramsMap = new TreeMap<String, String>();
				paramsMap.put("act", "do");
				paramsMap.put("msgcontent", content);
				paramsMap.put("msgmobile", mobile);
				flag = HttpUtil.httpMethodPost(
						ResourceReader.readValue("sendSMS_url"), paramsMap);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return flag;
	}
}
