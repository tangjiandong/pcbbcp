package com.app.utils.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MapUtil {

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
			
		} catch (UnsupportedEncodingException e) {
			
		} catch (IOException e) {
			
		} finally {
			if (uc != null) {
				uc.disconnect();
			}
		}
		return sb.toString();
	}
	
	public static String  getMapLngAndLat(String city,String address){
		 
		try {
			String sendSMS_url = "http://api.map.baidu.com/geocoder/v2/?ak=AFb384572541f823e4ece035b73a54c6&callback=renderOption&output=json&address="+address+"&city="+city;
			String sb_res = commonMethod(sendSMS_url);
			JSONObject jsonObj;
			JSONObject jsonObj2;
			String json=sb_res.substring(sb_res.indexOf('(')+1, sb_res.indexOf(')'));
			JSONObject jsonObject = JSONArray.fromObject("["+json+"]").getJSONObject(0);
			jsonObj = JSONArray.fromObject(jsonObject.get("result")).getJSONObject(0);
			jsonObj2 = JSONArray.fromObject(jsonObj.get("location")).getJSONObject(0);
			return jsonObj2.toString();
		} catch (Exception e) {
			return "error";
		}
		
	}
}
