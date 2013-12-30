/**
 * 文件名: HttpUtil.java
 * 作者：caiqf
 * 完成日期：2012-11-7
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.utils.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Class: HttpUtil.java Description: 淘宝数据对接工具类
 * 
 * @author caiqf
 * @date 2012-11-7
 */
public class HttpUtil {
	private static final Log log = LogFactory.getLog(HttpUtil.class);

	/**
	 * 
	 * HTTP协议GET请求方法
	 */
	public static String httpMethodGet(String url) {
		StringBuffer sb = new StringBuffer();
		URL urls;
		HttpURLConnection uc = null;
		BufferedReader in = null;
		try {
			urls = new URL(url);
			uc = (HttpURLConnection) urls.openConnection();
			uc.setRequestMethod("GET");
			uc.connect();
			in = new BufferedReader(new InputStreamReader(uc.getInputStream(),
					"utf-8"));
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}
			if (in != null) {
				in.close();
			}
			if (uc != null) {
				uc.disconnect();
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (uc != null) {
				uc.disconnect();
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * HTTP协议POST请求方法
	 */
	public static String httpMethodPost(String url,
			TreeMap<String, String> paramsMap) {
		String params = null;
		if (null != paramsMap) {
			params = getParamStr(paramsMap);
		}

		StringBuffer sb = new StringBuffer();
		URL urls;
		HttpURLConnection uc = null;
		BufferedReader in = null;
		try {
			urls = new URL(url);
			uc = (HttpURLConnection) urls.openConnection();
			uc.setDoOutput(true);
			uc.setDoInput(true);
			uc.setRequestMethod("POST");
			uc.setUseCaches(false);
			uc.connect();
			DataOutputStream out = new DataOutputStream(uc.getOutputStream());
			out.write(params.getBytes("gbk"));
			out.flush();
			out.close();
			in = new BufferedReader(new InputStreamReader(uc.getInputStream(),
					"gbk"));
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}
			if (in != null) {
				in.close();
			}
			if (uc != null) {
				uc.disconnect();
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			if (uc != null) {
				uc.disconnect();
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * HTTP协议POST请求添加参数的封装方法
	 */
	private static String getParamStr(TreeMap<String, String> paramsMap) {
		StringBuilder param = new StringBuilder();
		for (Iterator<Map.Entry<String, String>> it = paramsMap.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry<String, String> e = it.next();
			param.append("&").append(e.getKey()).append("=")
					.append(e.getValue());
		}
		return param.toString().substring(1);
	}
}
