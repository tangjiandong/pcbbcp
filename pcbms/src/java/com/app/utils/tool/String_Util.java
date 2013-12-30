package com.app.utils.tool;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_Util {
	
	public static String getTitle(String value) {
		if (value == null || value.equals("")) return "";
		
		value = value.replaceAll("[\\r\\n\\ \\　]", "");	 	// 换行
		value = value.replaceAll(" ", ""); 					// 空字符串
		value = value.replaceAll("　", ""); 					// 全角空字符串
		value = value.replaceAll("\"", "“");				// 双引号
		value = value.replaceAll("\'", "‘");				// 单引号
		
		return value;
	}
	
	/**
	 * 对备注进行替换
	 * @param value 传入的字符串
	 * @return 将传入字符串中的引号、双引号替换为全角字符串
	 */
	public static String getRemark(String value) {
		if (value == null || value.equals("")) return "";
		
		value = value.replaceAll("[\\r\\n\\ \\　]", "");	 	// 换行
		value = value.replaceAll(" ", ""); 					// 空字符串
		value = value.replaceAll("　", ""); 					// 全角空字符串
		value = value.replaceAll("\'", "‘");				// 单引号
		value = value.replaceAll("\"", "“");				// 双引号
		
		return value;
	}
	/**
	 * 处理空字符串
	 * @param value 传入的字符串
	 * @return 将传入字符串中的引号、双引号替换为全角字符串
	 */
	public static String doNull(String value) {
		if (value == null || value.equals("")) return "";
		
//		value = value.replaceAll("[\\r\\n\\ \\　]", "");	 	// 换行
//		value = value.replaceAll(" ", ""); 					// 空字符串
//		value = value.replaceAll("　", ""); 					// 全角空字符串
//		value = value.replaceAll("\'", "‘");				// 单引号
//		value = value.replaceAll("\"", "“");				// 双引号
		
		return value.trim();
	}
	
	/**
	 * 对备注进行替换并返回指定长度的字符串
	 * @param value 传入的字符串
	 * @param length 欲返回长度
	 * @return 将传入字符串中的引号、双引号替换为全角字符串
	 */
	public static String getRemark(String value, int length) {
		if (value == null || value.equals("")) return "";
		
		value = value.replaceAll("[\\r\\n\\ \\　]", "");	 	// 换行
		value = value.replaceAll(" ", ""); 					// 空字符串
		value = value.replaceAll("　", ""); 					// 全角空字符串
		value = value.replaceAll("\'", "‘");				// 单引号
		value = value.replaceAll("\"", "“");				// 双引号
		
		if (value.length() > length) {
			value = value.substring(0, length);
		}
		
		return value;
	}
	
	/**
	 * 检查是否是手机号 如果为手机号返回 true 否返回 false
	 * @param value 传入手机号
	 */
	public static boolean checkMobile(String value) {
		if (value == null || value.equals("")) return false;
		
		String regex = "^(13|15|18)[0-9]{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		matcher = pattern.matcher(value);
		if (!matcher.matches()) {			
			return false;
		}
		
		return true;
	}
	
	/**
	 * 将传入的字符串中换行，控制符替换为空字符串
	 * @param s 传入的字符串
	 * @return 将传入的字符串中换行，控制符替换为空字符串
	 */
	public static String getStrForEnter(String str) {
		str = str.replaceAll("[\\r\\n\\ \\　]", "");	
		return str;
	}
	
	/**
	 * 将传入的字符串转换为正常短信发送字符
	 * @param s 传入的字符串
	 * @return 转换为正常短信发送字符
	 */
	public static String getStrForValid(String str) {
		str = str.replaceAll("０","0");
		str = str.replaceAll("１","1");
		str = str.replaceAll("２","2");
		str = str.replaceAll("３","3");
		str = str.replaceAll("４","4");
		str = str.replaceAll("５","5");
		str = str.replaceAll("６","6");
		str = str.replaceAll("７","7");
		str = str.replaceAll("８","8");
		str = str.replaceAll("９","9");

		str = str.replaceAll("ａ","a");
		str = str.replaceAll("ｂ","b");
		str = str.replaceAll("ｃ","c");
		str = str.replaceAll("ｄ","d");
		str = str.replaceAll("ｅ","e");
		str = str.replaceAll("ｆ","f");
		str = str.replaceAll("ｇ","g");
		str = str.replaceAll("ｈ","h");
		str = str.replaceAll("ｉ","i");
		str = str.replaceAll("ｊ","j");
		str = str.replaceAll("ｋ","k");
		str = str.replaceAll("ｌ","l");
		str = str.replaceAll("ｍ","m");
		str = str.replaceAll("ｎ","n");
		str = str.replaceAll("ｏ","o");
		str = str.replaceAll("ｐ","p");
		str = str.replaceAll("ｑ","q");
		str = str.replaceAll("ｒ","r");
		str = str.replaceAll("ｓ","s");
		str = str.replaceAll("ｔ","t");
		str = str.replaceAll("ｕ","u");
		str = str.replaceAll("ｖ","v");
		str = str.replaceAll("ｗ","w");
		str = str.replaceAll("ｘ","x");
		str = str.replaceAll("ｙ","y");
		str = str.replaceAll("ｚ","z");
		str = str.replaceAll("Ａ","A");
		str = str.replaceAll("Ｂ","B");
		str = str.replaceAll("Ｃ","C");
		str = str.replaceAll("Ｄ","D");
		str = str.replaceAll("Ｅ","E");
		str = str.replaceAll("Ｆ","F");
		str = str.replaceAll("Ｇ","G");
		str = str.replaceAll("Ｈ","H");
		str = str.replaceAll("Ｉ","I");
		str = str.replaceAll("Ｊ","J");
		str = str.replaceAll("Ｋ","K");
		str = str.replaceAll("Ｌ","L");
		str = str.replaceAll("Ｍ","M");
		str = str.replaceAll("Ｎ","N");
		str = str.replaceAll("Ｏ","O");
		str = str.replaceAll("Ｐ","P");
		str = str.replaceAll("Ｑ","Q");
		str = str.replaceAll("Ｒ","R");
		str = str.replaceAll("Ｓ","S");
		str = str.replaceAll("Ｔ","T");
		str = str.replaceAll("Ｕ","U");
		str = str.replaceAll("Ｖ","V");
		str = str.replaceAll("Ｗ","W");
		str = str.replaceAll("Ｘ","X");
		str = str.replaceAll("Ｙ","Y");
		str = str.replaceAll("Ｚ","Z");
		str = str.replaceAll("．",".");
		str = str.replaceAll("　"," ");
		str = str.replaceAll("（","(");
		str = str.replaceAll("）",")");
		str = str.replaceAll("｛","{");
		str = str.replaceAll("｝","}");
		str = str.replaceAll("［","[");
		str = str.replaceAll("］","]");
		str = str.replaceAll("＜","〈");
		str = str.replaceAll("＞","〉");
		str = str.replaceAll("「","“");

		str = str.replaceAll("」","”");
		str = str.replaceAll("｀","`");
		str = str.replaceAll("～","~");
		str = str.replaceAll("！","!");
		str = str.replaceAll("＠","@");
		str = str.replaceAll("＃","#");
		str = str.replaceAll("％","%");
		str = str.replaceAll("＾","^");
		str = str.replaceAll("※","&");
		str = str.replaceAll("＊","*");
		str = str.replaceAll("－","-");
		str = str.replaceAll("＿","_");
		str = str.replaceAll("＋","+");
		str = str.replaceAll("＝","=");
		str = str.replaceAll("｜","|");
		str = str.replaceAll("＼","\\");
		str = str.replaceAll("■","-");
		str = str.replaceAll("＇","’");
		str = str.replaceAll("／","/");
		str = str.replaceAll("；",";");
		str = str.replaceAll("：",":");
		str = str.replaceAll("，",",");
		str = str.replaceAll("。",".");
		str = str.replaceAll("？","?");
		
		return str;
	}
	
	/**
	 * 根据传入字符串检查是否为数字 若是返回 true 否返回 false
	 */
	public static boolean checkNumber(String value) {
		try {
			new BigDecimal(value);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}
	
	/**
	 * 对发送短信内容进行处理
	 */
	public static String getSmsContent(String value) {
		value = getStrForEnter(value);
		value = getStrForValid(value);
		
		return value;
	}
	/**
	 * 根据传入字符串检查是否为空或空字符 如果是则为true 否则为false
	 */
	public static boolean checkObjectIsBank(Object obj) {
		try {
			if (obj == null || obj.toString().trim().equals("")) {
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return true;
		}

	}
}
