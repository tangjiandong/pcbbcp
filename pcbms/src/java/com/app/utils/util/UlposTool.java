/**
 * 文件名: UlposTool.java
 * 作者：caiqf
 * 完成日期：2012-8-27
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.utils.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.app.utils.constant.MD5;
import com.app.utils.tool.ResourceReader;

/**
 * Class: UlposTool.java Description: U联生活工具类
 * 
 * @author caiqf
 * @date 2012-8-27
 */
public class UlposTool {
	protected static final Log log = LogFactory.getLog(UlposTool.class);

	public static String appkey = ResourceReader.readValue("ulpos_appkey"); // 平台分配的appkey
	public static String appsecret = ResourceReader
			.readValue("ulpos_appsecret"); // 平台分配的appsecret
	public static String signature_method = ResourceReader
			.readValue("ulpos_signature_method"); // 加密类型md5
	public static String url_bankInfo = ResourceReader
			.readValue("ulpos_url_bankInfo"); // 银行信息url
	public static String url_couponsInfo = ResourceReader
			.readValue("ulpos_url_couponsInfo"); // 优惠券信息url
	public static String url_couponsAdd = ResourceReader
			.readValue("ulpos_url_couponsAdd"); // 添加优惠券信息url
	public static String url_vipCard = ResourceReader
			.readValue("ulpos_url_vipcard"); // 商户会员卡信息url
	public static String url_vipcardInfo = ResourceReader
			.readValue("ulpos_url_vipcardInfo"); // 会员卡查询url
	public static String url_vipcardAdd = ResourceReader
			.readValue("ulpos_url_vipcardAdd"); // 绑定会员卡信息url
	public static String ulpos_changeBankCard = ResourceReader
			.readValue("ulpos_url_changeBankCard"); // 更改会员卡绑定的银行卡号url
	public static String url_bankCheck = ResourceReader
			.readValue("ulpos_url_bankCheck"); // 验证银行卡号格式是否正确url
	public static String page = "1"; // 分页数
	public static String pagesize = "20"; // 分页数量，最大20

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-27 下午02:41:16
	 * @describe 获取最新的时间戳和签名
	 * @return String
	 */
	public static String getNewTimestampAndSign() {
		String key = UlposTool.appkey;
		String secret = UlposTool.appsecret;
		String method = UlposTool.signature_method;
		long times = new Date().getTime() / 1000;
		return key
				+ ","
				+ method
				+ ","
				+ times
				+ ","
				+ MD5.getInstance().getMD5(key + times + secret + method)
						.toLowerCase();
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-28 下午12:34:11
	 * @describe 处理请求公共方法
	 * @return String
	 */
	public static String commonMethod(String url) {
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
		} catch (MalformedURLException e) {
			log.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
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
	 * @author caiqf
	 * @date 2012-8-27 上午11:50:33
	 * @describe 获取银行数据
	 * @return String
	 */
	public static String transportBankInfo() {
		String[] ts = UlposTool.getNewTimestampAndSign().split(","); // 时间戳+签名
		String url = UlposTool.url_bankInfo + "?appkey=" + ts[0]
				+ "&signature_method=" + ts[1] + "&timestamp=" + ts[2]
				+ "&sign=" + ts[3];
		return UlposTool.commonMethod(url);
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-27 上午11:50:33
	 * @describe 获取优惠券、优惠券商户数据
	 * @return String
	 */
	public static String transportCouponsInfo(String page, String pagesize) {
		String[] ts = UlposTool.getNewTimestampAndSign().split(","); // 时间戳+签名
		String url = UlposTool.url_couponsInfo + "?appkey=" + ts[0]
				+ "&signature_method=" + ts[1] + "&timestamp=" + ts[2]
				+ "&sign=" + ts[3] + "&page=" + page + "&pagesize=" + pagesize
				+ "&state=1&shopcolumn=*&coucolumn=*";
		return UlposTool.commonMethod(url);
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-27 上午11:50:33
	 * @describe 绑定优惠券
	 * @return String
	 */
	public static String transportAddCouponsInfo(String couid, String mobile,
			String card, String orderid) {
		String[] ts = UlposTool.getNewTimestampAndSign().split(","); // 时间戳+签名
		String url = UlposTool.url_couponsAdd + "?appkey=" + ts[0]
				+ "&signature_method=" + ts[1] + "&timestamp=" + ts[2]
				+ "&sign=" + ts[3] + "&couid=" + couid + "&mobile=" + mobile
				+ "&card=" + card + "&orderid=" + orderid;
		return UlposTool.commonMethod(url);
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-27 上午11:50:33
	 * @describe 获取会员卡、会员卡商户数据
	 * @return String
	 */
	public static String transportVipCard(String page, String pagesize) {
		String[] ts = UlposTool.getNewTimestampAndSign().split(","); // 时间戳+签名
		String url = UlposTool.url_vipCard + "?appkey=" + ts[0]
				+ "&signature_method=" + ts[1] + "&timestamp=" + ts[2]
				+ "&sign=" + ts[3];
		return UlposTool.commonMethod(url);
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-27 上午11:50:33
	 * @describe 查询会员卡
	 * @return String
	 */
	public static String transportCardInfo(String page, String pagesize,
			String uvcid) {
		String[] ts = UlposTool.getNewTimestampAndSign().split(","); // 时间戳+签名
		String url = UlposTool.url_vipcardInfo + "?appkey=" + ts[0]
				+ "&signature_method=" + ts[1] + "&timestamp=" + ts[2]
				+ "&sign=" + ts[3] + "&uvcid=" + uvcid;
		return UlposTool.commonMethod(url);
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-27 上午11:50:33
	 * @describe 绑定会员卡
	 * @return String
	 */
	public static String transportAddCardsInfo(String mobile, String cardno,
			String svcid, String orderid) {
		String[] ts = UlposTool.getNewTimestampAndSign().split(","); // 时间戳+签名
		String url = UlposTool.url_vipcardAdd + "?appkey=" + ts[0]
				+ "&signature_method=" + ts[1] + "&timestamp=" + ts[2]
				+ "&sign=" + ts[3] + "&mobile=" + mobile + "&cardno=" + cardno
				+ "&svcid=" + svcid + "&orderid=" + orderid;
		return UlposTool.commonMethod(url);
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-27 上午11:50:33
	 * @describe 更改会员卡绑定的银行卡号
	 * @return String
	 */
	public static String transportChangeBankCard(String mobile, String cardno,
			String uvcid) {
		String[] ts = UlposTool.getNewTimestampAndSign().split(","); // 时间戳+签名
		String url = UlposTool.ulpos_changeBankCard + "?appkey=" + ts[0]
				+ "&signature_method=" + ts[1] + "&timestamp=" + ts[2]
				+ "&sign=" + ts[3] + "&mobile=" + mobile + "&cardno=" + cardno
				+ "&uvcid=" + uvcid;
		return UlposTool.commonMethod(url);
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-27 上午11:50:33
	 * @describe 验证银行卡号格式是否正确
	 * @return String
	 */
	public static String transportCheckBankInfo(String cardno) {
		String[] ts = UlposTool.getNewTimestampAndSign().split(","); // 时间戳+签名
		String url = UlposTool.url_bankCheck + "?appkey=" + ts[0]
				+ "&signature_method=" + ts[1] + "&timestamp=" + ts[2]
				+ "&sign=" + ts[3] + "&cardno=" + cardno;
		return UlposTool.commonMethod(url);
	}
}
