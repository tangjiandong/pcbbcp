/**
 * 文件名: RandomUtil.java
 * 作者：caiqf
 * 完成日期：2012-12-14
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.utils.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.math.RandomUtils;

import com.app.utils.constant.MD5;

/**
 * Class: RandomUtil.java Description: 随机数工具类
 * 
 * @author caiqf
 * @date 2012-12-14
 */
@SuppressWarnings("all")
public class RandomUtil {
	private final static Random rm = new Random();

	private final static String[] stringNumber = { "01", "02", "03", "04",
			"05", "06", "07", "08", "09" };

	/**
	 * 字符串号码倒序
	 * 
	 * @param str
	 *            字符串
	 * @param sign
	 *            标识符号
	 * @return String [返回类型说明]
	 * @author caiqf
	 */
	public static String orderStr(String str, String sign) {
		String strArr[] = str.split("\\" + sign);
		int in, out;
		for (out = 1; out < strArr.length; out++) {
			int itemp = Integer.valueOf(strArr[out]).intValue();
			String stemp = strArr[out];
			in = out;
			while (in > 0
					&& Integer.valueOf(strArr[in - 1]).intValue() >= itemp) {
				strArr[in] = strArr[in - 1];
				--in;
			}
			strArr[in] = stemp;
		}
		for (int k = 0; k < strArr.length; k++) {
			if (k == 0) {
				str = strArr[k];
			} else {
				str += sign + strArr[k];
			}
		}
		return str;
	}

	/**
	 * 随机生成一个整数
	 * 
	 * @param max
	 * @return
	 */
	public static int randomOneInt(int max) {
		return rm.nextInt(max);
	}

	/**
	 * 随机生成一个小于10的整数字符
	 * 
	 * @param max
	 * @return
	 */
	public static String randomOneString(int max) {
		return (new Integer(rm.nextInt(max))).toString();
	}

	/** 计算出现次数 */
	public static int frequency(String str) {
		int count = 0;
		String[] val = str.split(",");
		for (int i = 0; i < val.length; i++) {
			for (int j = 0; j < val.length; j++) {
				if (val[i].equals(val[j]))
					count++;
			}
		}
		return count;
	}

	/** 以长度来分割字符串 */
	public static String splitStr(String str, int length) {
		String restr = null;
		int count = str.length() / length;
		for (int i = 0; i < count; i++) {
			if (i == 0)
				restr = str.substring(0, length);
			else
				restr += "," + str.substring(0, length);
			str = str.substring(length, str.length());
		}
		return restr;
	}

	/**
	 * 返回长度为length的字符串随机数
	 * 
	 * @param length
	 *            长度
	 */
	public static String randomForMedian(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			int tempInt = randomOneInt(10);
			if (i == 0 && 0 == tempInt)
				tempInt = randomOneInt(9) + 1;
			str += tempInt;
		}
		return str;
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-12-14 上午11:19:17
	 * @describe 随机生成任意长度的数字组合字符串
	 * @return String
	 */
	public static String nextLength(int length) {
		String num = "";
		for (int i = 0; i < length; i++) {
			num += RandomUtils.nextInt(10);
		}
		return num;
	}

	/**
	 * @author caiqifan
	 * @date 2012-4-20 上午10:49:12
	 * @describe 随机生成MD5加密后的N位字符串(str-序列或规则字符串；n-N位字符串)
	 * @return String
	 * @exception
	 * @version 1.0
	 */
	public static String getUUID(String str, int n) {
		if (n > 32) {
			n = 32;
		}
		UUID uuid = UUID.randomUUID();
		String guid = str + "-" + uuid.toString();
		try {
			guid = MD5.getInstance()
					.getNBitMD5(
							new String(guid.replace("-", "").getBytes("UTF-8"),
									"UTF-8"), n);
			guid = guid.toUpperCase();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return guid;
	}

	/**
	 * @author caiqifan
	 * @date 2012-4-20 上午10:49:12
	 * @describe 随机生成MD5加密后的N位纯数字组合序列号，格式如(1111 2222 3333 4444)
	 * @return String
	 * @exception
	 * @version 1.0
	 */
	public static String getSerialNumberByMD5(String id, int n) {
		String guid = "";
		String str = id + RandomUtil.randomForMedian((n - id.length()));
		if (null != str && !"".equals(str)) {
			String[] num = new String[str.length() / 4];
			for (int i = 0; i < num.length; i++) {
				num[i] = str.substring(0, 4);
				str = str.substring(4);
			}
			if (null != num && num.length > 0) {
				for (int i = 0; i < num.length; i++) {
					guid += num[i] + " ";
				}
				guid = guid.substring(0, guid.length() - 1);
			}
		}
		return guid;
	}

	/**
	 * @author caiqifan
	 * @date 2012-4-20 上午10:49:12
	 * @describe 随机生成N位纯数字组合序列号，格式如(11112222333344445555)
	 * @return String
	 * @exception
	 * @version 1.0
	 */
	public static String getSerialNumber(String id, int n) {
		String guid = "";
		if (null != id && !"".equals(id)) {
			guid = id + RandomUtil.randomForMedian((n - id.length()));
		}
		return guid;
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-2 下午06:59:40
	 * @describe 去除一组字符串中重复的字符(数字组合)
	 * @return String[]
	 */
	public static String clearRepeatStr(String str, String sign) {
		String result = "";
		HashSet hs = new HashSet();
		if (null != str && !"".equals(str)) {
			String[] r = str.split(sign);
			for (int i = 0; i < r.length; i++) {
				hs.add(r[i]);
			}
			for (Iterator iterator = hs.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				result += object.toString() + sign;
			}
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-24 下午02:22:40
	 * @describe Double转Integer
	 * @return Integer
	 */
	public static Integer convertDoubleToInt(Double price, Integer num) {
		BigDecimal big = new BigDecimal(String.valueOf(price));
		return big.multiply(new BigDecimal(num)).intValue();
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-8-24 下午02:22:40
	 * @describe 截取指定长度的String转Integer
	 * @return Integer
	 */
	public static Integer convertStringToInt(String str, Integer num) {
		return Integer.parseInt(str.substring(str.length() - num));
	}
}
